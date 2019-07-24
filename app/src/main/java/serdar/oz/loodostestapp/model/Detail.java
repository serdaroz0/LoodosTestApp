package serdar.oz.loodostestapp.model;

import java.util.List;

public class Detail {

    /**
     * Title : Batman
     * Year : 1989
     * Rated : PG-13
     * Released : 23 Jun 1989
     * Runtime : 126 min
     * Genre : Action, Adventure
     * Director : Tim Burton
     * Writer : Bob Kane (Batman characters), Sam Hamm (story), Sam Hamm (screenplay), Warren Skaaren (screenplay)
     * Actors : Michael Keaton, Jack Nicholson, Kim Basinger, Robert Wuhl
     * Plot : The Dark Knight of Gotham City begins his war on crime with his first major enemy being the clownishly homicidal Joker.
     * Language : English, French, Spanish
     * Country : USA, UK
     * Awards : Won 1 Oscar. Another 8 wins & 26 nominations.
     * Poster : https://m.media-amazon.com/images/M/MV5BMTYwNjAyODIyMF5BMl5BanBnXkFtZTYwNDMwMDk2._V1_SX300.jpg
     * Ratings : [{"Source":"Internet Movie Database","Value":"7.6/10"},{"Source":"Rotten Tomatoes","Value":"71%"},{"Source":"Metacritic","Value":"69/100"}]
     * Metascore : 69
     * imdbRating : 7.6
     * imdbVotes : 314,665
     * imdbID : tt0096895
     * Type : movie
     * DVD : 25 Mar 1997
     * BoxOffice : N/A
     * Production : Warner Bros. Pictures
     * Website : N/A
     * Response : True
     */

    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private String Metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String Type;
    private String DVD;
    private String BoxOffice;
    private String Production;
    private String Website;
    private String Response;
    private List<RatingsBean> Ratings;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String Rated) {
        this.Rated = Rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String Released) {
        this.Released = Released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String Runtime) {
        this.Runtime = Runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String Writer) {
        this.Writer = Writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String Actors) {
        this.Actors = Actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String Plot) {
        this.Plot = Plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String Awards) {
        this.Awards = Awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String Poster) {
        this.Poster = Poster;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String Metascore) {
        this.Metascore = Metascore;
    }

    public String getİmdbRating() {
        return imdbRating;
    }

    public void setİmdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getİmdbVotes() {
        return imdbVotes;
    }

    public void setİmdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getİmdbID() {
        return imdbID;
    }

    public void setİmdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDVD() {
        return DVD;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }

    public String getBoxOffice() {
        return BoxOffice;
    }

    public void setBoxOffice(String BoxOffice) {
        this.BoxOffice = BoxOffice;
    }

    public String getProduction() {
        return Production;
    }

    public void setProduction(String Production) {
        this.Production = Production;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String Response) {
        this.Response = Response;
    }

    public List<RatingsBean> getRatings() {
        return Ratings;
    }

    public void setRatings(List<RatingsBean> Ratings) {
        this.Ratings = Ratings;
    }

    public static class RatingsBean {
        /**
         * Source : Internet Movie Database
         * Value : 7.6/10
         */

        private String Source;
        private String Value;

        public String getSource() {
            return Source;
        }

        public void setSource(String Source) {
            this.Source = Source;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }
    }
}
