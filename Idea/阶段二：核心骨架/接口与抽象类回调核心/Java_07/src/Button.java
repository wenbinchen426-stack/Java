import interfaces.OnClickListener;
import view.View;

class Button {
    private View view;
    private OnClickListener listener;

    public Button(String text) {
        this.view = new View(text);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        if (listener != null) {
            listener.onClick(view);
        }
    }
}
