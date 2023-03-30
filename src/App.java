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
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        int a = Integer.parseInt(JOptionPane.showInputDialog("O que vocês gostaria de ver: \n1-Melhores Filmes \n2-Filmes Populares \n3-Melhores séries \n4- Séries Pouplares\n"));

        if (a == 1){
            //MELHORES FILMES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
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

                //icone = new FileInputStream(new File("./icon/eu.jpg") );
                
                extracted(geradora, rodape, inputStream, icone, nomeArquivo);

               /* for (int i=1 ; i < estrela; i++ ){
                    System.out.print(" ⭐");
                }*/

                System.out.println("\n");                
                
            }
        }
        
        if (a == 2){
            //FILMES POPULARES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
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

                if (estrela <= 7 ){
                    rodape = "Não recomendado";
                    icone = new FileInputStream(new File("./icon/eu.jpg") );
                }

                if (estrela >= 7 && estrela <= 9){
                    rodape = "Recomendado";
                    icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
                }
                
                if (estrela >= 9){
                    rodape = "Muito recomendado";
                    icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
                }

                String nomeArquivo = titulo.replace(":", "-") + ".png";
                geradora.cria(inputStream, nomeArquivo, rodape, icone);

                System.out.println("\n");                
                
            }
        }

        if (a == 2){
            //FILMES POPULARES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
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
                int estrela = Math.round(ranking);
                String rodape = new String();
                
                InputStream inputStream = new URL(urlImagem).openStream();
                InputStream icone = null;

                if (estrela <= 7 ){
                    rodape = "Não recomendado";
                    icone = new FileInputStream(new File("./icon/eu.jpg") );
                }

                if (estrela >= 7 && estrela <= 9){
                    rodape = "Recomendado";
                    icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
                }
                
                if (estrela >= 9){
                    rodape = "Muito recomendado";
                    icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
                }

                String nomeArquivo = titulo.replace(":", "-") + ".png";

                //icone = new FileInputStream(new File("./icon/eu.jpg") );
                
                extracted(geradora, rodape, inputStream, icone, nomeArquivo);

               /* for (int i=1 ; i < estrela; i++ ){
                    System.out.print(" ⭐");
                }*/

                System.out.println("\n");                
                
            }
        }

        if (a == 3){
            //MELHORES SÉRIES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
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

                if (estrela <= 7 ){
                    rodape = "Não recomendado";
                    icone = new FileInputStream(new File("./icon/eu.jpg") );
                }

                if (estrela >= 7 && estrela <= 9){
                    rodape = "Recomendado";
                    icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
                }
                
                if (estrela >= 9){
                    rodape = "Muito recomendado";
                    icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
                }

                String nomeArquivo = titulo.replace(":", "-") + ".png";

                //icone = new FileInputStream(new File("./icon/eu.jpg") );
                
                extracted(geradora, rodape, inputStream, icone, nomeArquivo);

               /* for (int i=1 ; i < estrela; i++ ){
                    System.out.print(" ⭐");
                }*/

                System.out.println("\n");                
                
            }
        }

        if (a == 4){
            //MELHORES SÉRIES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
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

                if (estrela <= 7 ){
                    rodape = "Não recomendado";
                    icone = new FileInputStream(new File("./icon/eu.jpg") );
                }

                if (estrela >= 7 && estrela <= 9){
                    rodape = "Recomendado";
                    icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
                }
                
                if (estrela >= 9){
                    rodape = "Muito recomendado";
                    icone = new FileInputStream(new File("./icon/eu-joinha.jpg") );
                }

                String nomeArquivo = titulo.replace(":", "-") + ".png";

                //icone = new FileInputStream(new File("./icon/eu.jpg") );
                
                extracted(geradora, rodape, inputStream, icone, nomeArquivo);

               /* for (int i=1 ; i < estrela; i++ ){
                    System.out.print(" ⭐");
                }*/

                System.out.println("\n");                
                
            }
        }


    }

    private static void extracted(FabricaDeFigurinhas geradora, String rodape, InputStream inputStream,
            InputStream icone, String nomeArquivo) throws Exception {
        geradora.cria(inputStream, nomeArquivo, rodape, icone);
    }
}
