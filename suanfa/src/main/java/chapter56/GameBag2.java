package chapter56;

import java.util.Set;

/**
 * 动态规划
 * 游戏背包的代码实现(01背包)
 */
public class GameBag2 {

    public void putBag(Element[] goods,int bagSize){
        ArrayElement[][] calcArray=new ArrayElement[goods.length][bagSize];

        for(int i=0;i< goods.length;i++){
            for(int j=0;j<bagSize;j++){
                if(i==0){
                    // 第一行数据做特殊处理（只有一个物品选择的时候，要么放要么不放）
                    if(goods[i].getCost()<=j+1){
                        //放入元素
                        calcArray[i][j]=new ArrayElement(goods[i].getValue(),goods[i]);
                    }else{
                        //不放入元素
                        calcArray[i][j]=new ArrayElement();
                    }
                }else{
                    // 计算本单元格是否能放下当前物品
                    int spareSpace=j+1-goods[i].getCost();
                    if(spareSpace<0){
                        //放不下，直接使用上一行同列的数组
                        calcArray[i][j]=calcArray[i-1][j];
                    }else{
                        //可以放下，需要判断上一行同列的值和当前商品的价值+剩余空间的价值那个更大
                        int preRow=i-1;
                        //上一行同列的值
                        int preRowValue=calcArray[preRow][j].getValue();
                        //当前商品的价值
                        int currentGoodsValue=goods[i].getValue();

                        if(spareSpace>0) {
                            //是否有剩余空间，如果有剩余空间则获取剩余空间最大值
                            currentGoodsValue+=calcArray[preRow][spareSpace-1].getValue();
                        }

                        if(preRowValue>=currentGoodsValue){
                            //使用上一行同列的数据
                            calcArray[i][j]=calcArray[preRow][j];
                        }else{
                            if(spareSpace==0){
                                //空间只能够放当前物品
                                calcArray[i][j]=new ArrayElement(currentGoodsValue,goods[i]);
                            }else{
                                //剩余空间的最大价值存放物品
                                Set<Element> newElement = calcArray[preRow][spareSpace - 1].getElements();
                                // 加如当前物品
                                newElement.add(goods[i]);
                                calcArray[i][j]=new ArrayElement(currentGoodsValue,newElement);
                            }
                        }
                    }
                }
            }
        }
    }
}
