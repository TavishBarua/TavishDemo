package com.demo.tavish.Adapater;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.tavish.tavishdemo.R;

public class SliderAdapter extends PagerAdapter{


    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slideImgs={R.drawable.img_cart,
            R.drawable.img_road_sign,R.drawable.img_grad_cap};

     /*   public int[] slideImags={
                R.drawable.img_road_side,
                R.drawable.icn_mortarboard,
                R.drawable.img_graduate

        };*/

    public String[] slideHeadings={
            "E-commerce Sites",
            "Classified Websites",
            "Online Tutorials"

    };

    public String[] descrp={
            "Our E-commerce solutions will help you to find right products from right places",
            "Classified websites will help you to Post your business or services online for Free of cost",
            "Online tutorials gives best platform to all students to learn advance lessons from home"
    };

    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView  = (ImageView)view.findViewById(R.id.img_one);
        TextView slideHeading = (TextView) view.findViewById(R.id.txt_one);
        TextView slideDescrp = (TextView) view.findViewById(R.id.txt_two);

        slideImageView.setImageResource(slideImgs[position]);
        slideHeading.setText(slideHeadings[position]);
        slideDescrp.setText(descrp[position]);
         container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
