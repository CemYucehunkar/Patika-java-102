public class Cave extends BattleLoc{
    private boolean isFood=true;
    public Cave(Player player){
        super(player,"Mağara",new Zombie(),"Food",3);
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }
}