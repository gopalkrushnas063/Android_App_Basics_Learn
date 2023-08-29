package com.gopal.fetchecomgetapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final ArrayList<Product> products;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products.clear();
        this.products.addAll(products);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private final ImageView productImageView;
        private final TextView titleTextView;
        private final TextView priceTextView;
        private final TextView descriptionTextView;
        private final TextView categoryTextView;
        private final RatingBar ratingBar;
        private final TextView discountPercentageTextView;
        private final TextView stockTextView;
        private final TextView brandTextView;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            discountPercentageTextView = itemView.findViewById(R.id.discountPercentageTextView);
            stockTextView = itemView.findViewById(R.id.stockTextView);
            brandTextView = itemView.findViewById(R.id.brandTextView);
        }

        public void bind(Product product) {
            // Bind data to UI components here
            titleTextView.setText(product.getTitle());
            priceTextView.setText("$ " + String.valueOf(product.getPrice()) + " /-");
            discountPercentageTextView.setText("$ " + String.valueOf(product.getDiscountPercentage()) + " /-");
            stockTextView.setText("$ " + String.valueOf(product.getStock()) + " /-");
            brandTextView.setText(product.getBrand());
            descriptionTextView.setText(product.getDescription());
            categoryTextView.setText(product.getCategory());
            ratingBar.setRating((float) product.getRating());
            // Load image using a library like Picasso or Glide
            Picasso.get().load(product.getThumbnail()).into(productImageView);
        }
    }
}
