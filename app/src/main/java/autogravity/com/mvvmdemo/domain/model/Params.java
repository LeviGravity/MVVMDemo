package autogravity.com.mvvmdemo.domain.model;

/**
 * Created by LeviHsiao on 3/7/18.
 */

public class Params {

    private static int count;

    private Params(int count) {
        Params.count = count;
    }

    public int getCount() {
        return count;
    }

    public static Params setParams(final int count) {
        return new Params(count);
    }
}
