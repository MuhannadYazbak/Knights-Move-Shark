package model;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece{

	public Knight(Square currentPlace) {
		super(currentPlace);
	}

	@Override
	public Set<Square> allPossibleMoves() {
		HashSet<Square> possibleMoves = new HashSet<Square>();
		if((getCurrentPlace().getCol()==0 && getCurrentPlace().getRow()==0)) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		else if((getCurrentPlace().getCol()==7 && getCurrentPlace().getRow()==0)) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			}
		
		else if((getCurrentPlace().getCol()==0 && getCurrentPlace().getRow()==7)) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			}
		
		else if((getCurrentPlace().getCol()==7 && getCurrentPlace().getRow()==7)) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getCol()==0 && (getCurrentPlace().getRow()>=2 && getCurrentPlace().getRow()<=5))) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s3=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getCol()==7 && (getCurrentPlace().getRow()>=2 && getCurrentPlace().getRow()<=5))) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s3=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getRow()==0 && (getCurrentPlace().getCol()>=2 && getCurrentPlace().getCol()<=5))) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==7 && (getCurrentPlace().getCol()>=2 && getCurrentPlace().getCol()<=5))) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s3=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s4=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==1)) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==0)) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==6)) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==7)) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==7)) {
//			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s3=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			}
		
		if((getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==6)) {
//			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			}
		
		if((getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==1)) {
//			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			}
		
		if((getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==0)) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			}
		
		if((getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==1)) {
//			Square s1=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			}
		
		if((getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==6)) {
//			Square s1=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			}
		
		if((getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==6)) {
//			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			}
		
		if((getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==1)) {
//			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			}
		
		if((getCurrentPlace().getRow()==1 && (getCurrentPlace().getCol()==2 || getCurrentPlace().getCol()==3 || getCurrentPlace().getCol()==4 || getCurrentPlace().getCol()==5))) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s5=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			Square s6=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s5.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
		//	if(!s6.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getRow()==6 && (getCurrentPlace().getCol()==2 || getCurrentPlace().getCol()==3 || getCurrentPlace().getCol()==4 || getCurrentPlace().getCol()==5))) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s5=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s6=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s5.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		//	if(!s6.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getCol()==6 && (getCurrentPlace().getRow()==2 || getCurrentPlace().getRow()==3 || getCurrentPlace().getRow()==4 || getCurrentPlace().getRow()==5))) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			Square s5=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s6=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
		//	if(!s5.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s6.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getCol()==6 && (getCurrentPlace().getRow()==2 || getCurrentPlace().getRow()==3 || getCurrentPlace().getRow()==4 || getCurrentPlace().getRow()==5))) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			Square s5=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s6=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
		//	if(!s5.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s6.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			}
		if(getCurrentPlace().getCol()>1 && getCurrentPlace().getCol()<6 && getCurrentPlace().getRow()>1 && getCurrentPlace().getRow()<6){
//			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			Square s5=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s6=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s7=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s8=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		//	if(!s2.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		//	if(!s3.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		//	if(!s4.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
		//	if(!s5.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		//	if(!s6.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		//	if(!s7.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		//	if(!s8.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		}
//		if((getCurrentPlace().getCol()+2)<8) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
//		}else if((getCurrentPlace().getCol()+2)>8){
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2%8));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2%8));
//		}
//		if((getCurrentPlace().getCol()-2)>0) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
//		}else if((getCurrentPlace().getCol()-2)<0) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,(getCurrentPlace().getCol()-2)+8));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,(getCurrentPlace().getCol()-2)+8));
//		}
//		if((getCurrentPlace().getRow()+2)<8) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
//		}else if((getCurrentPlace().getRow()+2)>8) {
//		possibleMoves.add(new Square((getCurrentPlace().getRow()+2)%8,getCurrentPlace().getCol()+1));
//		possibleMoves.add(new Square((getCurrentPlace().getRow()+2)%8,getCurrentPlace().getCol()-1));
//		}if((getCurrentPlace().getRow()-2)>0) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
//		}else if((getCurrentPlace().getRow()-2)<0) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-2+8,getCurrentPlace().getCol()+1));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-2+8,getCurrentPlace().getCol()-1));
//		}
		return possibleMoves;
	}
	
	@Override
	public Set<Square> EmptyPossibleMoves() {
		HashSet<Square> EmptypossibleMoves = new HashSet<Square>();
		if((getCurrentPlace().getCol()==0 && getCurrentPlace().getRow()==0)) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		else if((getCurrentPlace().getCol()==7 && getCurrentPlace().getRow()==0)) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			}
		
		else if((getCurrentPlace().getCol()==0 && getCurrentPlace().getRow()==7)) {
			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			}
		
		else if((getCurrentPlace().getCol()==7 && getCurrentPlace().getRow()==7)) {
			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getCol()==0 && (getCurrentPlace().getRow()>=2 && getCurrentPlace().getRow()<=5))) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s3=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getCol()==7 && (getCurrentPlace().getRow()>=2 && getCurrentPlace().getRow()<=5))) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s3=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getRow()==0 && (getCurrentPlace().getCol()>=2 && getCurrentPlace().getCol()<=5))) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==7 && (getCurrentPlace().getCol()>=2 && getCurrentPlace().getCol()<=5))) {
			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s3=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s4=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==1)) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==0)) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==6)) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==7)) {
			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==7)) {
			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s3=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			}
		
		if((getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==6)) {
			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			}
		
		if((getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==1)) {
			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			}
		
		if((getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==0)) {
			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			}
		
		if((getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==1)) {
			Square s1=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			}
		
		if((getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==6)) {
			Square s1=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			}
		
		if((getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==6)) {
			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			}
		
		if((getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==1)) {
			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			}
		
		if((getCurrentPlace().getRow()==1 && (getCurrentPlace().getCol()==2 || getCurrentPlace().getCol()==3 || getCurrentPlace().getCol()==4 || getCurrentPlace().getCol()==5))) {
			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s5=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			Square s6=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);

			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s5.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			if(!s6.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getRow()==6 && (getCurrentPlace().getCol()==2 || getCurrentPlace().getCol()==3 || getCurrentPlace().getCol()==4 || getCurrentPlace().getCol()==5))) {
			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			Square s3=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s4=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s5=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			Square s6=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s5.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			if(!s6.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getCol()==6 && (getCurrentPlace().getRow()==2 || getCurrentPlace().getRow()==3 || getCurrentPlace().getRow()==4 || getCurrentPlace().getRow()==5))) {
			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			Square s5=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s6=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			if(!s5.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s6.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getCol()==6 && (getCurrentPlace().getRow()==2 || getCurrentPlace().getRow()==3 || getCurrentPlace().getRow()==4 || getCurrentPlace().getRow()==5))) {
			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			Square s5=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s6=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			if(!s5.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s6.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			}
		if(getCurrentPlace().getCol()>1 && getCurrentPlace().getCol()<6 && getCurrentPlace().getRow()>1 && getCurrentPlace().getRow()<6){
			Square s1=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
			Square s5=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
			Square s6=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
			Square s7=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
			Square s8=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
			
			if(!s1.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			if(!s2.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			if(!s3.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			if(!s4.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			if(!s5.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			if(!s6.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			if(!s7.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			if(!s8.isVisisted())
				EmptypossibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		}
//		if((getCurrentPlace().getCol()+2)<8) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
//		}else if((getCurrentPlace().getCol()+2)>8){
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2%8));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2%8));
//		}
//		if((getCurrentPlace().getCol()-2)>0) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
//		}else if((getCurrentPlace().getCol()-2)<0) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,(getCurrentPlace().getCol()-2)+8));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,(getCurrentPlace().getCol()-2)+8));
//		}
//		if((getCurrentPlace().getRow()+2)<8) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
//		}else if((getCurrentPlace().getRow()+2)>8) {
//		possibleMoves.add(new Square((getCurrentPlace().getRow()+2)%8,getCurrentPlace().getCol()+1));
//		possibleMoves.add(new Square((getCurrentPlace().getRow()+2)%8,getCurrentPlace().getCol()-1));
//		}if((getCurrentPlace().getRow()-2)>0) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
//		}else if((getCurrentPlace().getRow()-2)<0) {
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-2+8,getCurrentPlace().getCol()+1));
//		possibleMoves.add(new Square(getCurrentPlace().getRow()-2+8,getCurrentPlace().getCol()-1));
//		}
		return EmptypossibleMoves;
	}

	@Override
	public void moveThePiece(Set<Square> possibleMoves) {
		// TODO Auto-generated method stub
		
		
	}
	public void moveThePiecK(Set<Square> possibleMoves, int i, int j) {
		for (Square S : possibleMoves) {
			if(S.getCol() ==i && S.getRow()== j) {
				this.setCurrentPlace(S);
			}
		}
	}
}