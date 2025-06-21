import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class WhiteTextSpinnerAdapter extends ArrayAdapter<String> {

    public WhiteTextSpinnerAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundColor(Color.WHITE); // Set background color to white
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundColor(Color.WHITE); // Set background color to white
        return view;
    }
}
