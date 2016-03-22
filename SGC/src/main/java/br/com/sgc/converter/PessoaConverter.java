package br.com.sgc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.com.sgc.model.Pessoa;
import br.com.sgc.repository.PessoaFisicaRepository;
import br.com.sgc.tool.ConnectionJPA;
import br.com.sgc.tool.FacesTool;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		EntityManager entityManager = ConnectionJPA.getEntityManager();
		try {
			if (value != null && !"".equals(value)) {
				//return new PessoaFisicaRepository(entityManager).selectIdRepository(new Long(value));
				
				/* 
				 * Melhorar o bloco if&else usando operador ternário "?"
				 */
				
				if(new PessoaFisicaRepository(entityManager).selectIdRepository(new Long(value)) == null){
					FacesTool.addMessage_Error("Esta Pessoa Não Exite");
				}else {
					return new PessoaFisicaRepository(entityManager).selectIdRepository(new Long(value));
				}
			}
			return null;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getId().toString();
		}
		return null;
	}
}
