package lab8.part4;

import javax.swing.ImageIcon;

public class Football implements Chain{

	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		// TODO Auto-generated method stub
		this.nextChain = nextChain;
	}

	@Override
	public ImageIcon addImage(ImageIcons request) {
		// TODO Auto-generated method stub
		if(request.selection==0){
			return request.imageIcon;
		}
		else{
			nextChain.addImage(request);
		}
		return null;
	}

}
