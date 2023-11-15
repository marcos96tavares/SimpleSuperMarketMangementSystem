package ColletionFolder;

import java.util.Date;

public class Activity {

    private static int ACTIVITY_ID = 0;
    private int activity_id;
    private String activityName;
    private int activityQuantity;
    private Date activityDate;
    private int product_id;

    public Activity(String activityName, int activityQuantity, int product_id) {
        this.activityName = activityName;
        this.activityQuantity = activityQuantity;
        this.product_id = product_id;
        activity_id = ACTIVITY_ID++;
        activityDate = new Date();
    }

    public  int getActivityId() {
        return activity_id;
    }



    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getActivityQuantity() {
        return activityQuantity;
    }

    public void setActivityQuantity(int activityQuantity) {
        this.activityQuantity = activityQuantity;
    }

    public Date getActivityDate() {
        return activityDate;
    }



    public int getProduct_id() {
        return product_id;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activity-id='" + getActivityId() + '\'' +
                "activityName='" + activityName + '\'' +
                ", activityQuantity=" + activityQuantity +
                ", activityDate=" + activityDate +
                '}';
    }
}
