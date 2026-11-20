class StockSpanner {

    static class StockDay {
        private int price;
        private int streak;

        public StockDay(int price, int streak){
            this.price = price;
            this.streak = streak;
        }
    }

    private Stack<StockDay> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int consecutiveDays = 1;
        while (!stack.isEmpty() && stack.peek().price <= price){
            StockDay prevDay = stack.pop();
            consecutiveDays += prevDay.streak;
        }
        stack.push(new StockDay(price, consecutiveDays));
        return consecutiveDays;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */