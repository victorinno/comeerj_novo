select concat('INSERT INTO `comeerj`.`dados_equipe`(`dados`,`equipe`)VALUES(',
c.COD_FICHA_INSCRICAO_COMEERJ_ID,
',',
e.idEquipe,
');')  from comeerj c, equipe e
where c.DSC_TIPO_COMISSAO = e.nome;


