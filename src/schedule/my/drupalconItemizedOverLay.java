package schedule.my;

import java.util.ArrayList;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class drupalconItemizedOverLay extends ItemizedOverlay<OverlayItem> 
{
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	public Context mContext;
	
	public drupalconItemizedOverLay(Drawable defaultMarker) 
	{
		super(boundCenterBottom(defaultMarker));
	}
	
	public drupalconItemizedOverLay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		  mContext = context;
		}
	
	@Override
	protected OverlayItem createItem(int i) 
	{
	  return mOverlays.get(i);
	}

	@Override
	public int size() 
	{
	  return mOverlays.size();
	}
	
	public void addOverlay(OverlayItem overlay) 
	{
	    mOverlays.add(overlay);
	    populate();
	}
	
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = mOverlays.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
	  dialog.setTitle(item.getTitle());
	  dialog.setMessage(item.getSnippet());
	  dialog.setNeutralButton("O.K.", leavt);
	  dialog.show();
	  return true;
	}
	
	 DialogInterface.OnClickListener leavt = new DialogInterface.OnClickListener()  //initialize click listener for raise
		{
				public void onClick(DialogInterface dialog, int id) 
			    {
					Toast.makeText(mContext, ":^)", Toast.LENGTH_SHORT).show(); 
			    }
	    };
	
}
