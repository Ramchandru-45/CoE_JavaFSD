package com;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomScheduler {
	
	Map<String,MeetingRoom> mapRoom;
	
	RoomScheduler(){
		mapRoom=new HashMap<>();
	}
	
	public boolean addMeetingRoom(MeetingRoom room) {
		if(room!=null) {
			mapRoom.put(room.roomId, room);
			System.out.println("Room Added: "+room.roomName+", ID:"+room.roomId);
			return true;
		}
		return false;
	}
	
	public boolean bookRoom(String roomId,EnumSet<RoomFeature> req) {
		
		if(mapRoom.containsKey(roomId)) {
			mapRoom.get(roomId).booked=true;
			System.out.println("Room "+mapRoom.get(roomId).roomId+" booked Successfully");
			return true;
		}
		return false;
	}
	public void listAvailableRooms(EnumSet<RoomFeature> f) {
		List<String> al=new ArrayList<>();
		for(String id:mapRoom.keySet()) {
			if(mapRoom.get(id).features.containsAll(f)) {
				al.add(id);
			}
		}
		System.out.println("Available rooms with "+f.toString()+":"+al.toString());
	}
}

class MeetingRoom{
	String roomId;
	String roomName;
	int capacity;
	EnumSet<RoomFeature> features;
	boolean booked=false;
	
	public MeetingRoom(String roomId,String roomName,int capacity,EnumSet<RoomFeature> req) {
		this.roomId=roomId;
		this.roomName=roomName;
		this.capacity=capacity;
		this.features=req;
	}
}

enum RoomFeature{
	PROJECTOR,VIDEO_CONFERENCING,WHITEBOARD,CONFERENCE_PHONE,AIR_CONDITIONING;
}