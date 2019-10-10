package com.kk.data.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kk.data.R;
import com.kk.data.bean.Book;
import com.kk.data.callback.DBOperaListener;

import java.util.List;

/**
 * @Author: kk
 * @Create Date: 18-12-2 下午10:55
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is 书的适配器
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Book> bookList;
    private DBOperaListener dboPeraListener;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final Context context = viewGroup.getContext();
        final ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(
                viewGroup.getContext()).inflate(
                R.layout.book_item,
                viewGroup,
                false));
        viewHolder.bookItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if (dboPeraListener != null) {
                    Toast.makeText(context, "修改了" + bookList.get(position).getName() + "了！", Toast.LENGTH_SHORT).show();
                    dboPeraListener.onUpdate(position);
                }
            }
        });
        viewHolder.bookItemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if (dboPeraListener != null) {
                    Toast.makeText(context, "删除了" + bookList.get(position).getName() + "了！", Toast.LENGTH_SHORT).show();
                    dboPeraListener.onDelete(position);
                }
                return false;
            }
        });
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Book book = bookList.get(i);
        viewHolder.tvBookName.setText(book.getName());
        viewHolder.tvBookAuthor.setText(book.getAuthor());
        viewHolder.tvBookPages.setText(book.getPages() + "");
        viewHolder.tvBookPrices.setText(book.getPrice() + "¥");
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


    public void setDboPeraListener(DBOperaListener dboPeraListener) {
        this.dboPeraListener = dboPeraListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View bookItemView;
        TextView tvBookName;
        TextView tvBookAuthor;
        TextView tvBookPages;
        TextView tvBookPrices;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookItemView = itemView;
            tvBookName = itemView.findViewById(R.id.tv_item_name);
            tvBookAuthor = itemView.findViewById(R.id.tv_item_author);
            tvBookPages = itemView.findViewById(R.id.tv_item_pages);
            tvBookPrices = itemView.findViewById(R.id.tv_item_price);
        }
    }
}
