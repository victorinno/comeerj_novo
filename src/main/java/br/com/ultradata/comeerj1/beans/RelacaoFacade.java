/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.beans;

import br.com.ultradata.comeerj1.entidades.Relacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Victor
 */
@Stateless
public class RelacaoFacade
        extends AbstractFacade<Relacao> {

    @PersistenceContext(
            unitName = "br.com.ultradata_comeerj1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelacaoFacade() {
        super(Relacao.class);
    }

    public List<String> resgatarFaixas() {
        return em.createNativeQuery("select faixa from relacao group by 1").getResultList();
    }

    public List<String> nomesInvalidados() {
        return em.createNativeQuery("SELECT \n "
                                    + "    *\n "
                                    + "FROM \n "
                                    + "    (SELECT \n "
                                    + "         concat_ws(' - ' ,DSC_NOME, NOM_IE_PARTICIPA) AS NOME\n "
                                    + "    FROM\n "
                                    + "        relacao\n "
                                    + "    WHERE\n "
                                    + "        (NOT EXISTS( SELECT \n "
                                    + "                1\n "
                                    + "            FROM\n "
                                    + "                relacao_alojamento\n "
                                    + "            WHERE\n "
                                    + "                relacao_alojamento.idRelacao = relacao.COD_FICHA_INSCRICAO_COMEERJ_ID)\n "
                                    + "            OR NOT EXISTS( SELECT \n "
                                    + "                1\n "
                                    + "            FROM\n "
                                    + "                turma_evangelizandos\n "
                                    + "            WHERE\n "
                                    + "                turma_evangelizandos.idRelacao = relacao.COD_FICHA_INSCRICAO_COMEERJ_ID))\n "
                                    + "            AND relacao.DSC_TIPO_PARTICIPACAO IN ('Confraternista' , 'Pequenos Companheiros', 'Tarefeiro do Bem') UNION ALL SELECT \n "
                                    + "         concat_ws(' - ' ,DSC_NOME, NOM_IE_PARTICIPA) AS NOME\n "
                                    + "    FROM\n "
                                    + "        relacao\n "
                                    + "    WHERE\n "
                                    + "        (NOT EXISTS( SELECT \n "
                                    + "                1\n "
                                    + "            FROM\n "
                                    + "                relacao_alojamento\n "
                                    + "            WHERE\n "
                                    + "                relacao_alojamento.idRelacao = relacao.COD_FICHA_INSCRICAO_COMEERJ_ID)\n "
                                    + "            AND relacao.DSC_TIPO_PARTICIPACAO NOT IN ('Confraternista' , 'Pequenos Companheiros', 'Tarefeiro do Bem')))\n "
                                    + "            as FALTOSOS\n "
                                    + "ORDER BY 1\n").getResultList();
    }
}
