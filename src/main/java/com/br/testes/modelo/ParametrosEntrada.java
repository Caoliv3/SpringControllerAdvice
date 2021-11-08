package com.br.testes.modelo;


import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import com.br.testes.infra.ParametroEntradaException;
import lombok.Data;

@Data
public class ParametrosEntrada {

    private String canalConsulta;
    private String fonte;
    private String codigoCliente;
    private String tipoDocumento;
    private String documento;


    public void validarDados(){
        CPFValidator cpfValidator = new CPFValidator();
        CNPJValidator cnpjValidator = new CNPJValidator();

        if(!(tipoDocumento.equals("PF") || tipoDocumento.equals("PJ"))){
            throw new ParametroEntradaException("Tipo de documento diferente de PF e PJ");
        }

        if(tipoDocumento.equals("PF")){
            try {
                cpfValidator.assertValid(documento);
            }catch (Exception e){
               throw new  ParametroEntradaException("Documento PF Invalido : " + documento );
            }
        }else
            try {
                cnpjValidator.assertValid(documento);
            }catch (Exception e){
                throw new ParametroEntradaException("Documento PJ Invalido : " + documento);
            }
    }
}
