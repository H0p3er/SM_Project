package entity;

public class total {
    public class User {
        private int user_id;
        private String user_name;
        private String user_pass;
        private String user_nickname;
        private String user_fullname;
        private String user_images;
        private String user_email;
        private String user_notes;
        private String User_birthday;
        private byte user_permission;     
        private byte user_gender;
        private String user_address;
        private String user_created_date;
        private boolean user_deleted;
        private String user_phone;
        private long user_logined;
    }

    public class shop {
        private int shop_id;
        private String shop_name;
        private String shop_address;
        private byte shop_status;
        private String shop_created_date;
        private String shop_website_link;
        private String shop_map_link;
        private boolean shop_deleted;
        private String shop_images;
        private String shop_notes;
        private String shop_phone;
        private String shop_email;
        private int shop_creator_id;
    }

    public class products {
        private int product_id;
        private String product_name;
        private byte product_status;
        private byte product_deleted;
        private int product_visited;
        private int product_price;
        private String product_images;
        private String product_notes;
        private String product_created_date;
        private String product_last_modified;
        private short product_quantity;
        private int product_pc_id;
        private String product_shop_id;
    }

    public class pc {
        private int pc_id;
        private String pc_name;
        private String pc_notes;
        private String pc_created_date;
        private String pc_image;
        private boolean pc_enable;
        private int pc_parent_id;
        private int pc_creator_id;
    }

    public class bill {
        private int bill_id;
        private String bill_created_date;
        private int bill_creator_id;
        private int bill_delivery_id;
    }

    public class bill_details{
        private int bd_id;
        private int bd_bill_id;
        private String bd_product_id;
        private int bd_product_quantity;
    }

    public class comment {
        private int comment_id;
        private String comment_content;
        private int comment_created_date;
        private int comment_creator_id;
        private int comment_product_id;
    }

    public class log {
        private int log_id; 
        private int log_user_id; 
        private byte log_user_permission; 
        private String log_username; 
        private byte log_action; 
        private byte log_position; 
        private String log_name; 
        private String log_notes; 
        private String log_created_date;
        private boolean log_deleted;
    }

    public class delivery {
        private int delivery_id;
        private String delivery_name;
    }

    public class sale {
        private int sale_id;
        private String sale_name;
        private int sale_product_id;
        private float sale_off_price;
        private float sale_off_price_percent;
        private String sale_start_date;
        private String sale_end_date;
    }
}
