import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        int a = Integer.parseInt(JOptionPane.showInputDialog("O que vocês gostaria de ver: \n1-Melhores Filmes \n2-Filmes Populares \n3-Melhores séries \n4- Séries Pouplares\n"));

        if (a == 1){
            //MELHORES FILMES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
            //lendoAPI.funcao(url);
            var comunicador = new ClienteHTTP();
            String json = comunicador.consumaAPI(url);
            var parser = new JsonParser();
            List<Map<String, String>> conteudoJSON = parser.parse(json);
        }
        
        if (a == 2){
            //FILMES POPULARES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
            lendoAPI.funcao(url);
        }
        
        if (a == 3){
            //MELHORES SÉRIES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
            lendoAPI.funcao(url);
        }

        if (a == 4){
            //MELHORES SÉRIES
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
            lendoAPI.funcao(url);
        }
    
    }
}
