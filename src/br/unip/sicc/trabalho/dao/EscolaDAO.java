package br.unip.sicc.trabalho.dao;

import java.util.List;

import br.unip.sicc.trabalho.model.Escola;
import br.unip.sicc.trabalho.model.TipoEscola;

public interface EscolaDAO {
	
	public List<Escola> getTodos() throws DaoException;

	public List<Escola> getEscolaPorTipo(TipoEscola tipo) throws DaoException;

	public void incluir(Escola escola) throws DaoException;

	public void excluir(Escola escola) throws DaoException;

	public void atualizar(Escola escola) throws DaoException;

}
