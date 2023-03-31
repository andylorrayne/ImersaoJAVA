
import java.util.List;
import java.util.Map;

public class TrataDadosNASA implements TrataDados {
    public List <Conteudo> extraiConteudo (String json){
        
        var parser = new JsonParser();
        List<Map<String, String>> listaAtributos = parser.parse(json);

        return listaAtributos.stream().map(atributos -> new Conteudo( atributos.get("title"), atributos.get("url")))
                .toList();
  
    }
  
 }
