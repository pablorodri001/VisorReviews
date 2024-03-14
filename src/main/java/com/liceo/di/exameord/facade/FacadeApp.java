package com.liceo.di.exameord.facade;

import com.liceo.di.exameord.review.Review;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FacadeApp implements Serializable {

    private static FacadeApp instance = new FacadeApp();
    private Map<Integer, Review> reviewList;
    private Integer idCount;

    /**
     * Constructor (private) in order to implement Singleton Pattern,
     * the constructor initialize the Application instance with some example data.
     */
    private FacadeApp() {
        this.initialiseApp();
    }

    /**
     * Get an instance of the Application.
     *
     * @return the instance of Application
     */
    public static FacadeApp getAppInstance() {
        return instance;
    }

    /**
     * Initialize the Application instance.
     * You only need this if you like reinitialize all the data.
     */
    public void initialiseApp() {
        this.reviewList = new HashMap<Integer, Review>();
        this.idCount = 0;
        loadExampleData();
    }


    /**
     * Gets the whole Review List.
     *
     * @return the Review List, if there is no Review or no review list the List returned will be empty
     */
    public List<Review> getReviewList() {
        if (this.reviewList == null) {
            return new ArrayList<>();
        }
        return new ArrayList<Review>(this.reviewList.values());
    }

    /**
     * Filters the Reviews by author field.
     *
     * @param pattern the substring that the Review should match
     * @return the List with the Review that match the pattern given
     */
    public List<Review> filterReviewListByAuthor(String pattern) {
        List<Review> result = new ArrayList<>();
        for (Review review : this.reviewList.values()) {
            if (review.getAuthor().toLowerCase().contains(pattern.toLowerCase())) {
                result.add(review);
            }
        }
        return result;
    }

    /**
     * Filters the Reviews by text field.
     *
     * @param pattern the substring that the Review should match
     * @return the List with the Review that match the pattern given
     */
    public List<Review> filterReviewListByText(String pattern) {
        List<Review> result = new ArrayList<>();
        for (Review review : this.reviewList.values()) {
            if (review.getText().toLowerCase().contains(pattern.toLowerCase())) {
                result.add(review);
            }
        }
        return result;
    }


    /**
     * Adds a Review object to the Review list with the proper id parameter
     * this function use the same number as key in the Review Map.
     *
     * @param review to be added
     * @return the id of new review added
     */
    public Integer addReview(Review review) {
        Integer id = this.idCount++;
        review.setId(id);
        this.reviewList.put(id, review);
        return id;
    }

    /**
     * Add like to a Review.
     *
     * @param idReview Review object wich contains the new information of a Review object
     * @throws InvalidIdReviewException when the Id of idReview does not exist on Review List
     */
    public void likeReview(int idReview) throws InvalidIdReviewException {
        Review review = this.reviewList.get(idReview);
        if (review == null) {
            throw new InvalidIdReviewException("There aren't any Review with the id '"+ idReview +"'.");
        }
        review.like();
    }

    /**
     * Add dislike to a Review.
     *
     * @param idReview Review object wich contains the new information of a Review object
     * @throws InvalidIdReviewException when the Id of idReview does not exist on Review List
     */
    public void dislikeReview(int idReview) throws InvalidIdReviewException {
        Review review = this.reviewList.get(idReview);
        if (review == null) {
            throw new InvalidIdReviewException("There aren't any Review with the id '"+ idReview +"'.");
        }
        review.dislike();
    }

    /**
     * Aux function to loads likes and dislikes data
     */
    private void likeAndDislikeReviews(int likes, int dislikes, int idReview) {
        for (int i = 0; i < likes; i++) {
            try {
                likeReview(idReview);
            } catch (InvalidIdReviewException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < dislikes; i++) {
            try {
                dislikeReview(idReview);
            } catch (InvalidIdReviewException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Loads into the Review list some example data.
     */
    private void loadExampleData() {
        int edelmiro = addReview(new Review(
                "Edelmiro",
                "Está todo moi rico e moi abundante.",
                LocalDate.of(2024, 1, 16))
        ).intValue();
        likeAndDislikeReviews(5, 4, edelmiro);

        int pijo = addReview(new Review(
                "Señor pijo",
                "Comida de batalla. Era visto por ese precio...",
                LocalDate.of(2023, 12, 20))
        ).intValue();
        likeAndDislikeReviews(1, 1, pijo);

        int maria = addReview(new Review(
                "María la portuguesa",
                "Comida increible, pero la decoración podía estar mucho mejor, camareros muy atentos.",
                LocalDate.of(2024, 2, 13))
        ).intValue();
        likeAndDislikeReviews(3, 1, maria);

        int troll = addReview(new Review(
                "trollman",
                "Camareros muy lentos, comida insipida y decoración inexistente",
                LocalDate.of(2023, 10, 20))
        ).intValue();
        likeAndDislikeReviews(132, 432, troll);

        int outro = addReview(new Review(
                "outro máis",
                "Comida rica, pero pouco variada. É un sitio para comer ben e rápido.")
        ).intValue();
        likeAndDislikeReviews(3, 4, outro);
    }
}
