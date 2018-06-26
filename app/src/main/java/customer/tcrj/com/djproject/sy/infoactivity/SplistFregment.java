package customer.tcrj.com.djproject.sy.infoactivity;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.base.BaseFragment;

/**
 * Created by leict on 2018/4/24.
 */

public class SplistFregment extends BaseFragment {

    @BindView(R.id.btn_sp)
    TextView btn_sp;



    @Override
    protected int setLayout() {
        return R.layout.splist_layout;
    }

    @Override
    protected void setView() {


    }

    @Override
    protected void setData() {

    }
}
