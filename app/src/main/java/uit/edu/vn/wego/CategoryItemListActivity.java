package uit.edu.vn.wego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import uit.edu.vn.wego.R;
import uit.edu.vn.wego.adapter.CategoryAdapter;
import uit.edu.vn.wego.adapter.ModelItemCategory;
import uit.edu.vn.wego.adapter.ModelItemUser;

public class CategoryItemListActivity extends AppCompatActivity {

    private CategoryAdapter adapter;
    private RecyclerView recyclerview;
    private ArrayList<ModelItemCategory> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_item_list);

        String selected_category = getIntent().getStringExtra("selected_category");
        recyclerview = findViewById(R.id.category_item_recyclerview);

        ImageView home_button = findViewById(R.id.home_btn_1);
        ImageView profile_button = findViewById(R.id.profile_btn_1);
        ImageView fav_button = findViewById(R.id.fav_btn_1);

        ImageView search_btn = findViewById(R.id.search_btn);

        switch(selected_category)
        {
            case "famous_place":
                initialize_famous_place_category();
                break;
            case "place_by_region":
                initialize_place_by_region_category();
                break;
        }

        home_button.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryItemListActivity.this,HomeScreenActivity.class);
            startActivity(intent);
        });

        profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryItemListActivity.this,ProfileActivity.class);
            startActivity(intent);
        });

        fav_button.setOnClickListener(v -> {
            ModelItemUser user = LoginActivity.getUser();
            if(user != null)
            {
                Intent intent = new Intent(v.getContext(), ReviewPosts.class);
                intent.putExtra("selected_item", "user_fav_list");
                ((Activity)v.getContext()).startActivity(intent);
            }
            else
            {
                Toast.makeText(v.getContext(), "Please login first.", Toast.LENGTH_LONG).show();
            }
        });

        search_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), ReviewPosts.class);
            intent.putExtra("selected_item", "search");
            startActivity(intent);
        });
    }

    private void initialize_famous_place_category()
    {
        array = new ArrayList<ModelItemCategory>();
        array.add(new ModelItemCategory("Hà Nội",
                "https://icdn.dantri.com.vn/2020/10/09/ha-noi-hien-dai-1010-nam-5-1602262537931.jpg",
                "hanoi"));
        array.add(new ModelItemCategory("Sơn La",
                "https://dulichtaybac.vn/wp-content/uploads/2017/09/bai-hat-tay-bac-nam-xua-don-bac-ho-123815659911360.jpg",
                "sonla"));
        array.add(new ModelItemCategory("Quảng Ninh",
                "https://img.nhandan.com.vn/Files/Images/2020/09/26/5-1601059856224.jpg",
                "quangninh"));
        array.add(new ModelItemCategory("Lào Cai",
                "https://static1.cafeland.vn/cafelandData/upload/tintuc/thitruong/2020/05/tuan-02/lao-cai-duyet-gia-khoi-diem-dau-gia-quyen-su-dung-dat-tren-dia-ban-tinh-1589203096.jpg",
                "laocai"));
        array.add(new ModelItemCategory("Khánh Hòa",
                "https://bqldann.khanhhoa.gov.vn/media/cats/gioi-thieu/tong-quan-ve-khanh-hoa-2.jpg",
                "khanhhoa"));
        array.add(new ModelItemCategory("Huế",
                "https://dulichkhampha24.com/wp-content/uploads/2020/06/hue-kich-cau-du-lich-c.jpg",
                "hue"));
        array.add(new ModelItemCategory("Quảng Nam",
                "https://dulichfun.com/wp-content/uploads/2019/05/Kinh-nghiem-du-lich-Quang-Nam.jpg",
                "quangnam"));
        array.add(new ModelItemCategory("Quảng Bình",
                "https://img.nhandan.com.vn/Files/Images/2020/10/28/qb_1-1603825054413.jpg",
                "quangbinh"));
        array.add(new ModelItemCategory("Đà Nẵng",
                "https://danangfantasticity.com/wp-content/uploads/2020/02/da-nang-noi-hoi-tu-cua-tiem-nang-du-lich-03.jpg",
                "danang"));
        array.add(new ModelItemCategory("Đà Lạt",
                "https://vcdn1-dulich.vnecdn.net/2019/05/23/12-1558593963.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=sEbfKs9N6CgwUja6gayIJA",
                "dalat"));
        array.add(new ModelItemCategory("Hồ Chí Minh",
                "https://images.hcmcpv.org.vn/res/news/2020/04/27-04-2020-tphcm-trung-tam-kinh-te-khong-ngung-dot-pha-sang-tao-phat-trien-CFAFCE7.jpg",
                "tphcm"));
        array.add(new ModelItemCategory("Vũng Tàu",
                "https://media.baodautu.vn/Images/manhcuong/2020/04/29/ba-ria---vung-tau-thuc-hien-dong-bo-nhieu-giai-phap-phat-trien1588170854.jpg",
                "vungtau"));
        array.add(new ModelItemCategory("Kiên Giang",
                "https://photo-cms-plo.zadn.vn/w800/Uploaded/2021/gtnngu/2020_07_30/du-lich-phu-quoc_hhge.jpg",
                "kiengiang"));
        array.add(new ModelItemCategory("Tây Ninh",
                "https://baokhanhhoa.vn/dataimages/201812/original/images5350546_A5.jpg",
                "tayninh"));
        adapter = new CategoryAdapter(this, array);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initialize_place_by_region_category()
    {
        array = new ArrayList<ModelItemCategory>();
        array.add(new ModelItemCategory("Miền Bắc",
                "https://cdn.yeudulich.com/media/cms/8a/18/8168-f0df-4531-a5f7-806bd60a7728.jpg",
                "mienbac"));
        array.add(new ModelItemCategory("Miền Trung",
                "https://odt.vn/storage/01-2021/tay-nguyen-don-mot-loat-du-an-cua-cac-ong-lon.jpg",
                "mientrung"));
        array.add(new ModelItemCategory("Miền Nam",
                "https://amazingthingsinvietnam.com/wp-content/uploads/2018/11/10-diem-du-lich-mien-nam-dep-nhat-khong-the-bo-lo-amazingthingsinvietnam-2-1-1024x576.jpg",
                "miennam"));
        adapter = new CategoryAdapter(this, array);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}