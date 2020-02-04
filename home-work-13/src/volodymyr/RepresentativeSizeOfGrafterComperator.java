package volodymyr;

import java.util.Comparator;

public class RepresentativeSizeOfGrafterComperator implements Comparator<Representative>{

	@Override
	public int compare(Representative o1, Representative o2) {
		return o1.getGrafterSize() > o2.getGrafterSize() ? 1: -1;
	}

}
