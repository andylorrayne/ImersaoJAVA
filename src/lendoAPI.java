import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class lendoAPI{

    public static void funcao(String url) throws Exception {
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
    
        var geradora = new FabricaDeFigurinhas();
    
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[37m \u001b[45m" + filme.get("title") + "\u001b[m");
            System.out.println("\u001b[36;1m \u001b[4m" + filme.get("image") +"\u001b[m" );
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            var ranking = Float.parseFloat(filme.get("imDbRating"));
                    //System.out.println(ranking);
            int estrela = Math.round(ranking);
            String rodape = new String();
                    
            InputStream inputStream = new URL(urlImagem).openStream();
            InputStream icone = null;
    
            if (estrela <= 6 ){
                rodape = "Não recomendado";
                icone = new FileInputStream(new File("./icon/eu.jpg") );
            }
    
            if (estrela == 5 && estrela <= 7){
                rodape = "Recomendado";
                icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
            }
                    
            if (estrela >= 8){
                rodape = "Muito recomendado";
                icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
            }
    
            String nomeArquivo = titulo.replace(":", "-") + ".png";   
                
            geradora.cria(inputStream, nomeArquivo, rodape, icone);
    
                
    
            System.out.println("\n");
        }            
        
    }
}
    
   