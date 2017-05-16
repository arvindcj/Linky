import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Controller
    implements ActionListener {

    Model model;
    View view;
    
    public void actionPerformed(ActionEvent event) {
	model.parseHTML(event.getActionCommand().toLowerCase());
    }

    public void addModel(Model m) {
	this.model = m;
    } 

    public void addView(View v) {
	this.view = v;
    }

    public void initModel(int x){
	//model.setValue(x);
    } 
}
