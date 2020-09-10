package DynamicProgramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {


	public boolean canReach(int[] arr, int start) {

		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		q.add(start);

		while(!q.isEmpty()){

			Integer poppedIndex = q.poll();

			if(arr[poppedIndex] == 0){
				return true;
			}

			if(visited.contains(poppedIndex)){
				continue;
			}else{
				visited.add(poppedIndex);
			}

			if(poppedIndex+arr[poppedIndex]< arr.length){
				q.add(poppedIndex+arr[poppedIndex]);
			}

			if(poppedIndex-arr[poppedIndex]>=0){
				q.add(poppedIndex-arr[poppedIndex]);
			}

		}
		return false;

	}

	public boolean canReachRec(int[] arr, int start){
		if (0 <= start && start < arr.length ){
			if(arr[start] >= 0){
				arr[start] = -arr[start];
				if(arr[start] == 0){
					return true;
				}else{
					return  canReach(arr, start + arr[start]) ||
							canReach(arr, start - arr[start]);
				}  
			}else{
				return false; // visiting same number second time
			}
		}else{
			return false;
		}
	}

}




