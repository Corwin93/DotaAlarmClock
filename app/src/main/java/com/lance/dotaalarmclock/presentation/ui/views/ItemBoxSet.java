package com.lance.dotaalarmclock.presentation.ui.views;

import android.content.ClipData;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lance.dotaalarmclock.R;
import com.lance.dotaalarmclock.domain.model.entity.ItemTag;
import com.lance.dotaalarmclock.domain.model.entity.Type;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Corwin on 23.10.2017.
 */

public class ItemBoxSet extends LinearLayout implements Serializable {
    private Context mContext;
    private int mNumItems = 0;
    private int mNextFreeBoxNumber;
    private LinkedList<Object> mItemBoxTags;

    public ItemBoxSet(Context context) {
        super(context);
        init(context, null);
    }

    public ItemBoxSet(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ItemBoxSet(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ItemBoxSet(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        mItemBoxTags = new LinkedList<>();
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        final TypedArray styleAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.ItemBoxSet);
        mNumItems = styleAttributesArray.getInteger(R.styleable.ItemBoxSet_numItems, mNumItems);
        styleAttributesArray.recycle();
    }

    public void addItemBoxes(int numItems) {
        if (numItems != 0) {
            mNumItems = numItems;
            for (int i = 0; i < numItems; i++) {
                LinearLayout itemBox = getItemBoxView();
                ItemTag itemBoxTag = new ItemTag(Type.BOX, UUID.randomUUID());
                itemBox.setTag(itemBoxTag);
                addView(itemBox);
                mItemBoxTags.add(itemBoxTag);
            }
            mNextFreeBoxNumber = 0;
        }
    }

    public List<View> getChildViews() {
        List<View> viewList = new LinkedList<>();
        for (int i = 0; i < getChildCount(); i++) {
            viewList.add(getChildAt(i));
        }
        return viewList;
    }

    private LinearLayout getItemBoxView() {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout itemBox = (LinearLayout) layoutInflater.inflate(R.layout.item_box, this, false);
        itemBox.setOrientation(HORIZONTAL);
        itemBox.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        (int) getResources().getDimension(R.dimen.itemBoxWidth),
                        (int) getResources().getDimension(R.dimen.itemBoxHeight));
        layoutParams.setMarginStart(6);
        layoutParams.setMarginEnd(6);
        itemBox.setLayoutParams(layoutParams);
        return itemBox;
    }

    public LinkedList<Object> getItemBoxTags() {
        return mItemBoxTags;
    }

    public ItemTag addImage(int imageResId, boolean isTouchable) {
        ImageView image = new ImageView(mContext);
        Picasso.get().load(imageResId)
                .resize((int) getResources().getDimension(R.dimen.itemBoxWidth),
                        (int) getResources().getDimension(R.dimen.itemBoxHeight))
                .into(image);
        ItemTag itemTag = null;
        if (mNextFreeBoxNumber < mNumItems) {
            LinearLayout box = findViewWithTag(mItemBoxTags.get(mNextFreeBoxNumber));
            itemTag = new ItemTag(Type.IMAGE, ((ItemTag) box.getTag()).getId());
            image.setTag(imageResId);
            box.addView(image);
            if(isTouchable) {
                image.setOnTouchListener(new ImageTouchListener());
            }
            mNextFreeBoxNumber++;
            Log.d("addImage", box.getTag().toString() + "; " + itemTag);
        }
        return itemTag;
    }

    public void removeImage(ItemTag boxTag) {
        LinearLayout box = findViewWithTag(boxTag);
        if(box.getChildCount() > 0) {
            box.removeAllViews();
        }
    }

    public class ImageTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data, dragShadowBuilder, v, 0);
                } else {
                    v.startDrag(data, dragShadowBuilder, v, 0);
                }
                v.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }
}
