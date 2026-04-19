package media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh giảm dần theo Cost
        int costDiff = Float.compare(m2.getCost(), m1.getCost());
        if (costDiff != 0) {
            return costDiff;
        }
        // Nếu trùng Cost, so sánh theo Title (alphabet)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}