package com.xietian.graduated.task;

import com.xietian.graduated.pojo.Flight;
import com.xietian.graduated.pojo.OrderItem;
import com.xietian.graduated.pojo.Plane;
import com.xietian.graduated.pojo.Ticket;
import com.xietian.graduated.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SystemTask {

    @Autowired
    OrderService orderService;
    @Autowired
    FlightService flightService;
    @Autowired
    TicketService ticketService;
    @Autowired
    PlaneService planeService;
    @Autowired
    OrderItemService orderItemService;
//    @Scheduled(initialDelay = 1000*3, fixedDelay = 1000*3)
//    public void testScheduled(){
//        System.out.println("定时任务执行中！");
//    }
    private static List<String> ecoNum = Arrays.asList("A","B","C","D","E","F","G","H","I","J");
    private static List<String> busNum = Arrays.asList("K","L","M","N","O","P","Q","R","S","T");
    private static List<String> fcNum  = Arrays.asList("U","V","W","X","Y","Z");


    @Scheduled(initialDelay = 1000*5, fixedDelay = 1000*60)
    public void updateOrderStatus(){
        orderService.getOverdueOrderAndCancel();
    }

    @Scheduled(initialDelay = 1000*10, fixedDelay = 1000*60*10)
    public void autoDistributeSeat(){
        List<Flight> list = flightService.getEnableDistributeFlight();
        for(Flight f: list){
            Plane plane = planeService.getById(f.getpId()).getData();
            List<Ticket> tickets = ticketService.getByFid(f.getfId()).getData();

            for(Ticket t:tickets){
                List<OrderItem> oiList = orderItemService.getByTId(t.gettId());
                int seatNum = 0, passengerNum = oiList.size();
                switch(t.getRank()){
                    case (byte)1: seatNum = plane.getpEco();break;
                    case (byte)2: seatNum = plane.getpBus();break;
                    case (byte)3: seatNum = plane.getpFc(); break;
                }

                int[] arr = distribute(passengerNum, seatNum);
                numberingSeat(arr,t.getRank(),oiList);
            }
        }
    }

    private int[] distribute(int passengerNum, int seatNum){
        int[] arr = new int[passengerNum];
        int i=passengerNum, j=seatNum;
        int index=0;
        for(int k = 0; k < seatNum; k++){
            if(i>=j){
                arr[index++] = k;
                i -= j;
            }
            i += passengerNum;
        }
        return arr;
    }

    private void numberingSeat(int arr[], byte seatType, List<OrderItem> list){
        List<String> targetType = null;
        String headName = null;
        switch(seatType){
            case (byte)1: targetType = ecoNum; headName = "经济舱"; break;
            case (byte)2: targetType = busNum; headName = "商务舱"; break;
            case (byte)3: targetType = fcNum;  headName = "头等舱"; break;
        }

        for(int i=0; i<arr.length;i++){
            String seatNum = headName + targetType.get(arr[i]/10) + String.valueOf(arr[i]%10);
            orderItemService.updateSeat(list.get(i).getItemId(), seatNum);
        }
    }
}
