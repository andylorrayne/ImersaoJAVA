import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrataDadosNASA implements TrataDados {
    public List <Conteudo> extraiConteudo (String json){
        
        var parser = new JsonParser();
        List<Map<String, String>> listaAtributos = parser.parse(json);

        List <Conteudo> conteudos = new ArrayList< >();

        for (Map<String,String> atributos : listaAtributos) {

            
            String urlImagem = atributos.get("url");
            String titulo = atributos.get("title");

            
            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }
    
        return conteudos;
    }
  
 }
