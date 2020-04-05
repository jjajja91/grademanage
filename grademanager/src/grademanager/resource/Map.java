package grademanager.resource;

public class Map {
	
	int idx = 0;

	String[] keyArray = new String[100];
	Object[] valueArray = new Object[100];

	public Object get(String key) {
		for (int i = 0; i < idx; i++) {
			if (keyArray[i].equals(key)) {
				return valueArray[i];
			}
		}
		return null;
	}

	public void put(String key, Object value) {
		int i = 0;
		for (i = 0; i < idx; i++) {
			if (keyArray[i].equals(key)) {
				break;
			}
		}
		if (i == idx) {
			if (i < keyArray.length) {
				keyArray[i] = key;
				valueArray[i] = value;
				idx++;
			}
		} else {
			keyArray[i] = key;
			valueArray[i] = value;
		}
	}

	public Object delete(String key) {
		int i = 0;
		for (i = 0; i < idx; i++) {
			if(keyArray[i].equals(key)){
				break;
			}
		}
		if(i==idx){
			return null;
		}
		for(int j = i; j<idx; j++){
			keyArray[j]=keyArray[j+1];
			valueArray[j]=valueArray[j+1];
		}
		idx--;
		return valueArray[i];
	}

	public int length(){
		return idx;
	}	

}
