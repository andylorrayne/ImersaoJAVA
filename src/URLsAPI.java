public enum URLsAPI {

    URL_API_NASA ("https://api.nasa.gov/planetary/apod?api_key=Ct8lUUsKx3AyA3N1CKIL1LRBU5bEP42T3VBXhEGd&start_date=2022-04-26&end_date=2022-04-28"),
    URL_API_IMDB1 ("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"),
    URL_API_IMDB2 ("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json"),
    URL_API_IMDB3 ("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json"),
    URL_API_IMDB4 ("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json");

    private String url;

    URLsAPI(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    

}
