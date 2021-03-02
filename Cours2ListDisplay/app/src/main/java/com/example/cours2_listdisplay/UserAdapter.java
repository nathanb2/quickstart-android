package com.example.cours2_listdisplay;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private final ArrayList<User> mUsers;
    public UserAdapter(ArrayList<User> users) {
        mUsers = users;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.mDetailsTv.setText(String.format(Locale.getDefault(), "%s age de %d", user.getName(), user.getAge()));
        if (user.getAge() > 25) {
            holder.mContactIc.setImageDrawable(holder.mContactIc.getContext().getDrawable(R.drawable.ic_contact_red));
        }else {
            holder.mContactIc.setImageDrawable(holder.mContactIc.getContext().getDrawable(R.drawable.ic_contact_blue));
        }
    }
    @Override
    public int getItemCount() {
        if (mUsers != null) {
            return mUsers.size();
        }
        return 0;
    }
    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private final TextView mDetailsTv;
        private final ImageView mContactIc;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mDetailsTv = itemView.findViewById(R.id.IU_details_tv);
            mContactIc = itemView.findViewById(R.id.IU_contact_ic);
        }
    }
}
