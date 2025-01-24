
/**
 * La classe Persona aiuta lo sviluppatore a gestire i dati di tipo Persona
 * @author VettoriDanteMeucci
 * @version beta
 */

public class Persona {
    private String nome;
    private String cognome;
    private String cf;

    /**
     * Crea un nuovo oggetto di tipo persona se il cf viene inserito in formato inadeguato
     * verrà lanciata un eccezione
     * 
     * @param nome rappresenta il nome della persona
     * @param cognome rappresenta il cognome della persona
     * @param cf rappresenta il codice fiscale della persona
     * @throws Exception l'eccezione di default con messaggio "Il formato del CF non è valido"
     */
    public Persona(String nome, String cognome, String cf) throws Exception{
        this.nome = nome;
        this.cognome = cognome;
        this.cf = checkCF(cf);
        
    }

    private String checkCF(String code) throws Exception{
        code = code.toUpperCase();
        if(code.length()!= 16 || !isAlphanumeric(code))
            throw new Exception("Non lungo 16 char o non alfanumerico" );

        for(int i = 0 ; i <= 6; i++){
            if(isVowel(code.charAt(i))){
                throw new Exception("Uno dei primi sei caratteri non e' valido");
            }
        }

        if(!isNumber(code.charAt(6)) || !isNumber(code.charAt(7)) )
            throw new Exception("Non sono posizionati correttamente i valori in 7-8");

        return code;
    }

    private boolean isVowel(char val){
        return "AEIOU".indexOf(val) != -1;
    }

    private boolean isNumber(char c){
        return "0123456789".indexOf(c) != -1;
    }

    private boolean isAlphanumeric(String check){
        for(char digit : check.toCharArray()){
            if(!Character.isLetterOrDigit(digit)){
                return false;
            }
        }
        return true;
    }

}
