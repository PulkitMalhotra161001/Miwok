package com.example.miwok;

public class Word {

    /** Default translation for the word */
    private String english;

    /** Miwok translation for the word */
    private String hindi;

    /** Audio resource ID for the word */
    private int music;

    /** Image resource ID for the word */
    private int src = NO_IMAGE;

    /** Constant value that represents no image was provided for this word */
    private static int NO_IMAGE = -1;

    /**
     * Create a new Word object.
     *
     * @param eng is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param hin is the word in the Miwok language
     * @param src is the drawable resource ID for the image associated with the word
     * @param song is the resource ID for the audio file associated with this word
     */
    public Word(String eng, String hin,int src,int song){
        english = eng;
        hindi = hin;
        music=song;
        this.src=src;
    }

    /**
     * Create a new Word object.
     *
     * @param eng is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param hin is the word in the Miwok language
     * @param song is the resource ID for the audio file associated with this word
     */
    public Word(String eng, String hin,int song){
        english = eng;
        hindi = hin;
        music=song;
    }

    /**
     * Get the default translation of the word.
     */
    public String get_hindi(){
        return hindi;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String get_english(){
        return english;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int get_music(){
        return music;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int get_image(){
        return src;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() { return src!=NO_IMAGE; }

    @Override
    public String toString() {
        return "Word{" +
                "english='" + english + '\'' +
                ", hindi='" + hindi + '\'' +
                ", music=" + music +
                ", src=" + src +
                '}';
    }
}
