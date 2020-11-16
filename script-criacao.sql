CREATE TABLE vendedores (
	cdVend VARCHAR(36), 
    dsNome VARCHAR(50) NOT NULL, 
    cdTab INT NOT NULL, 
    dtNasc DATE, 
	PRIMARY KEY(cdVend)
);

CREATE TABLE clientes (
	cdCl VARCHAR(36), 
    dsNome VARCHAR(50) NOT NULL, 
    idTipo CHAR(2) NOT NULL DEFAULT 'PF', 
    cdVend VARCHAR(36),
    dsLim DECIMAL(15,2) NOT NULL, 
    CONSTRAINT fk_cdVend foreign key (cdVend) references vendedores(cdVend),
	PRIMARY KEY(cdCl)
);