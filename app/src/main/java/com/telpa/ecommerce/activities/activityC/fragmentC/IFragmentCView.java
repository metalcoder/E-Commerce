package com.telpa.ecommerce.activities.activityC.fragmentC;


import com.telpa.ecommerce.models.Category;
import java.util.ArrayList;

/**
 * Created by Gizem İlgar on 15.8.2016.
 */

public interface IFragmentCView {
    void viewAll();
    void setOtherSubCategories(ArrayList<Category> subCategories);
    void goToProduct(int ProductID);
    void RatingBar(int ProductID);

}
