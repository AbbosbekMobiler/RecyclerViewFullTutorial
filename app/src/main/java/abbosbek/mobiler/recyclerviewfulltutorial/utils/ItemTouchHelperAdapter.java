package abbosbek.mobiler.recyclerviewfulltutorial.utils;

public interface ItemTouchHelperAdapter {
    void itemMove(int fromPosition,int toPosition);
    void onItemDismiss(int position);
}
