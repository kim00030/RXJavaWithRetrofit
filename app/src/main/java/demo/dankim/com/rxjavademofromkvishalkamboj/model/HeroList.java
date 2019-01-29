package demo.dankim.com.rxjavademofromkvishalkamboj.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dan Kim on 2019-01-29
 *
 * This is not working....
 */
public class HeroList {

    @SerializedName("heros")
    @Expose
    private List<Hero> heroList = null;

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }
}
