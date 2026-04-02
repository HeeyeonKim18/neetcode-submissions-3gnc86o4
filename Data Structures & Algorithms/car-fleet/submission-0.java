class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
    
        for(int i = 0; i < position.length; i++){
            double time = (double) (target - position[i]) / speed[i];
            maxHeap.offer(new double[]{position[i], time});
        }

        int fleets = 0;
        double maxTime = 0.0;

        while(!maxHeap.isEmpty()){
            double[] car = maxHeap.poll();
            double currentTime = car[1];

            if(currentTime > maxTime){
                fleets++;
                maxTime = currentTime;
            }
        }
        return fleets;
    }
}
