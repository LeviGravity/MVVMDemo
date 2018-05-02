package autogravity.com.mvvmdemo.presentation.userlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import autogravity.com.mvvmdemo.R;
import autogravity.com.mvvmdemo.util.CircleTransform;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.domain.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Levi on 1/5/17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context context;
    private List<User> users = new ArrayList<>();

    public UserListAdapter(Context context) {
        this.context = context;
    }

    @NonNull @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_user, parent, false));
    }

    @Override public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (null != users && users.size() != 0) {
            User user = users.get(position);

            Glide.with(context)
                .load(user.getPicture().getMedium())
                .crossFade()
                .centerCrop()
                .transform(new CircleTransform(context))
                .into(holder.ivPhoto);

            holder.tvName.setText(user.getLogin().getUsername());
            holder.tvLocation.setText(String.format("%s, %s", user.getLocation().getCity(),
                user.getLocation().getState()));
        }
    }

    @Override public int getItemCount() {
        return users.size();
    }

    public void addUsers(List<User> users) {
        this.users.addAll(users);
        int curSize = getItemCount();
        notifyItemRangeInserted(curSize, users.size() - 1);
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo) ImageView ivPhoto;
        @BindView(R.id.tv_name) TextView tvName;
        @BindView(R.id.tv_location) TextView tvLocation;

        public UserViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
