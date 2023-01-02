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
				possibleMoves.add(new Square(getCurrentPlace().getRow()+7,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+6));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+7,getCurrentPlace().getCol()+6));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+6,getCurrentPlace().getCol()+7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+6,getCurrentPlace().getCol()+1));
				
			}
		
		if((getCurrentPlace().getCol()==7 && getCurrentPlace().getRow()==0)) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+7,getCurrentPlace().getCol()-2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+7,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getCol()==0 && getCurrentPlace().getRow()==7)) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-7,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-6,getCurrentPlace().getCol()+7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-6,getCurrentPlace().getCol()+1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+6));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-7,getCurrentPlace().getCol()+6));
			}
		
		if((getCurrentPlace().getCol()==7 && getCurrentPlace().getRow()==7)) {
//			Square s1=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-7,getCurrentPlace().getCol()-2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-6));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-7,getCurrentPlace().getCol()-6));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-6,getCurrentPlace().getCol()-7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-6,getCurrentPlace().getCol()-1));
			}
		
		if((getCurrentPlace().getCol()==0 && (getCurrentPlace().getRow()>=2 && getCurrentPlace().getRow()<=5))) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2);
//			Square s3=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+6));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+6));
			}
		
		if((getCurrentPlace().getCol()==7 && (getCurrentPlace().getRow()>=2 && getCurrentPlace().getRow()<=5))) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2);
//			Square s3=new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			
//			if(!s1.isVisisted())
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-7));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-7));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-6));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-6));
			}
		
		if((getCurrentPlace().getRow()==0 && (getCurrentPlace().getCol()>=2 && getCurrentPlace().getCol()<=5))) {
//			Square s1=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2);
//			Square s2=new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2);
//			Square s3=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1);
//			Square s4=new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1);
//			
//			if(!s1.isVisisted())
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+7,getCurrentPlace().getCol()-2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+7,getCurrentPlace().getCol()+2));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+6,getCurrentPlace().getCol()-1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+6,getCurrentPlace().getCol()+1));
			}
		
		if((getCurrentPlace().getRow()==7 && (getCurrentPlace().getCol()>=2 && getCurrentPlace().getCol()<=5))) {
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-7,getCurrentPlace().getCol()-2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-7,getCurrentPlace().getCol()+2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-6,getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-6,getCurrentPlace().getCol()+1));
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
		
		if((getCurrentPlace().getCol()==1 && (getCurrentPlace().getRow()==2 || getCurrentPlace().getRow()==3 || getCurrentPlace().getRow()==4 || getCurrentPlace().getRow()==5))) {
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
	public Set<Square> allPossibleMovesLevel2() {
		HashSet<Square> possibleMoves = new HashSet<Square>();
		if(getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==0 ) {

			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,1));
			possibleMoves.add(new Square(5,2));
			
			possibleMoves.add(new Square(6,5));
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,1));
			possibleMoves.add(new Square(6,3));
			
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,3));
			
			possibleMoves.add(new Square(1,5));
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,2));
			possibleMoves.add(new Square(1,3));
			
			possibleMoves.add(new Square(2,5));
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,1));
			possibleMoves.add(new Square(2,3));
			
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,2));
				
			}
		
		if(getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==7 ) {
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,6));
				possibleMoves.add(new Square(5,0));
				possibleMoves.add(new Square(5,1));
				
				possibleMoves.add(new Square(6,4));
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,2));
				
				possibleMoves.add(new Square(7,4));
				possibleMoves.add(new Square(7,5));
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,2));
				
				possibleMoves.add(new Square(1,4));
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,2));
				
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,6));
				possibleMoves.add(new Square(2,0));
				possibleMoves.add(new Square(2,2));
				
				possibleMoves.add(new Square(3,5));
				possibleMoves.add(new Square(3,6));
				possibleMoves.add(new Square(3,0));
				possibleMoves.add(new Square(3,1));
			}
		
		if(getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==7 ) {
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,1));
			
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,2));
			
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,5));
			possibleMoves.add(new Square(6,1));
			possibleMoves.add(new Square(6,2));
			
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,1));
			possibleMoves.add(new Square(0,2));
			
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,2));
			
			possibleMoves.add(new Square(2,5));
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,1));
			}
		
		if(getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==0 ) {
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,2));
			
			possibleMoves.add(new Square(5,5));
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,1));
			possibleMoves.add(new Square(5,3));
			
			possibleMoves.add(new Square(6,5));
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,2));
			possibleMoves.add(new Square(6,3));
			
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,3));
			
			possibleMoves.add(new Square(1,5));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,1));
			possibleMoves.add(new Square(1,3));
			
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,1));
			possibleMoves.add(new Square(2,2));
			}
		
		if(getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==1) {
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,2));
			possibleMoves.add(new Square(5,3));
			
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(6,2));
			possibleMoves.add(new Square(6,4));
			
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,4));
			
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,4));
			
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,2));
			possibleMoves.add(new Square(2,4));
			
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,2));
			possibleMoves.add(new Square(3,3));
			}
		
		if(getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==6) {
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,5));
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,0));
			
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,5));
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,1));
			
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,1));
			
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,1));
			
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,5));
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,1));
			
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,0));
			}
		
		if(getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==7) {
			possibleMoves.add(new Square(6,5));
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(6,1));
			
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,2));
			
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,1));
			possibleMoves.add(new Square(0,2));
			
			possibleMoves.add(new Square(2,4));
			possibleMoves.add(new Square(2,5));
			possibleMoves.add(new Square(2,1));
			possibleMoves.add(new Square(2,2));
			
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,2));
			
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,1));
			}
		
		if(getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==7) {
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,1));
			
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,2));
			
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,5));
			possibleMoves.add(new Square(5,1));
			possibleMoves.add(new Square(5,2));
			
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,1));
			possibleMoves.add(new Square(7,2));
			
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,2));
			
			possibleMoves.add(new Square(1,5));
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,1));
			}
		
		if(getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==6) {
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,0));
			
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,5));
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,1));
			
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(6,1));
			
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,1));
			
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,5));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,1));
			
			possibleMoves.add(new Square(2,4));
			possibleMoves.add(new Square(2,5));
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,0));
			}
		
		if(getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==1) {
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,2));
			possibleMoves.add(new Square(4,3));
			
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,2));
			possibleMoves.add(new Square(5,4));
			
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,4));
			
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,4));
			
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,2));
			possibleMoves.add(new Square(1,4));
			
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,2));
			possibleMoves.add(new Square(2,3));
			}
		
		if(getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==0) {
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,2));
			
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,3));
			
			possibleMoves.add(new Square(5,5));
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,2));
			possibleMoves.add(new Square(5,3));
			
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,3));
			
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,1));
			possibleMoves.add(new Square(0,3));
			
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,1));
			possibleMoves.add(new Square(1,2));
			}
		
		if(getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==0) {
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,1));
			possibleMoves.add(new Square(6,2));
			
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,1));
			possibleMoves.add(new Square(7,3));
			
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,3));
			
			possibleMoves.add(new Square(2,5));
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,2));
			possibleMoves.add(new Square(2,3));
			
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,3));
			
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,2));
			}
		if(getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==2) {
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,1));
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,4));
			
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,1));
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,5));
			
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,5));
			
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,5));
			
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,1));
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,5));
			
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,4));
			}
		
		if(getCurrentPlace().getRow()==0 && getCurrentPlace().getCol()==5) {
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,7));
			
			possibleMoves.add(new Square(6,2));
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,0));
			
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,0));
			
			possibleMoves.add(new Square(1,2));
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,0));
			
			possibleMoves.add(new Square(2,2));
			possibleMoves.add(new Square(2,4));
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,0));
			
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,7));
			}
		
		if(getCurrentPlace().getRow()==2 && getCurrentPlace().getCol()==7) {
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,1));
			
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,2));
			
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,5));
			possibleMoves.add(new Square(1,1));
			possibleMoves.add(new Square(1,2));
			
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,2));
			
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,2));
			
			possibleMoves.add(new Square(5,5));
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,1));
			}
		
		if(getCurrentPlace().getRow()==5 && getCurrentPlace().getCol()==7) {
			possibleMoves.add(new Square(2,5));
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,1));
			
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,2));
			
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,2));
			
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,5));
			possibleMoves.add(new Square(6,1));
			possibleMoves.add(new Square(6,2));
			
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,2));
			
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,1));
			}
		
		if(getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==5) {
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,7));
			
			possibleMoves.add(new Square(5,2));
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,0));
			
			possibleMoves.add(new Square(6,2));
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,0));
			
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,0));
			
			possibleMoves.add(new Square(1,2));
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,0));
			
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,4));
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,7));
			}
		
		if(getCurrentPlace().getRow()==7 && getCurrentPlace().getCol()==2) {
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,4));
			
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,1));
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,5));
			
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,5));
			
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,5));
			
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,1));
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,5));
			
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,1));
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,4));
			}
		
		if(getCurrentPlace().getRow()==5 && getCurrentPlace().getCol()==0) {
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,1));
			possibleMoves.add(new Square(2,2));
			
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,3));
			
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,2));
			possibleMoves.add(new Square(4,3));
			
			possibleMoves.add(new Square(6,5));
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,2));
			possibleMoves.add(new Square(6,3));
			
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,1));
			possibleMoves.add(new Square(7,3));
			
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,1));
			possibleMoves.add(new Square(0,2));
			}
		
		if(getCurrentPlace().getRow()==2 && getCurrentPlace().getCol()==0) {
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,1));
			possibleMoves.add(new Square(7,2));
			
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,1));
			possibleMoves.add(new Square(0,3));
			
			possibleMoves.add(new Square(1,5));
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,2));
			possibleMoves.add(new Square(1,3));
			
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,2));
			possibleMoves.add(new Square(3,3));
			
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,3));
			
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,1));
			possibleMoves.add(new Square(5,2));
			}
		
		if(getCurrentPlace().getRow()==0) {
			
			if(getCurrentPlace().getCol()==3) {
				possibleMoves.add(new Square(5,1));
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,4));
				possibleMoves.add(new Square(5,5));
				
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,2));
				possibleMoves.add(new Square(6,4));
				possibleMoves.add(new Square(6,6));
				
				possibleMoves.add(new Square(7,0));
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,5));
				possibleMoves.add(new Square(7,6));
				
				possibleMoves.add(new Square(1,0));
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,6));
				
				possibleMoves.add(new Square(2,0));
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,6));
				
				possibleMoves.add(new Square(3,1));
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,4));
				possibleMoves.add(new Square(3,5));
			}
			
			if(getCurrentPlace().getCol()==4) {
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,3));
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,6));
				
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,3));
				possibleMoves.add(new Square(6,5));
				possibleMoves.add(new Square(6,7));
				
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,2));
				possibleMoves.add(new Square(7,6));
				possibleMoves.add(new Square(7,7));
				
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,2));
				possibleMoves.add(new Square(1,6));
				possibleMoves.add(new Square(1,7));
				
				possibleMoves.add(new Square(2,1));
				possibleMoves.add(new Square(2,3));
				possibleMoves.add(new Square(2,5));
				possibleMoves.add(new Square(2,7));
				
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,3));
				possibleMoves.add(new Square(3,5));
				possibleMoves.add(new Square(3,6));
			}
			
			}
		
		if(getCurrentPlace().getCol()==7) {
			
			if(getCurrentPlace().getRow()==3) {
				possibleMoves.add(new Square(0,5));
				possibleMoves.add(new Square(0,6));
				possibleMoves.add(new Square(0,0));
				possibleMoves.add(new Square(0,1));
				
				possibleMoves.add(new Square(1,4));
				possibleMoves.add(new Square(1,6));
				possibleMoves.add(new Square(1,0));
				possibleMoves.add(new Square(1,2));
				
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,5));
				possibleMoves.add(new Square(2,1));
				possibleMoves.add(new Square(2,2));
				
				possibleMoves.add(new Square(4,4));
				possibleMoves.add(new Square(4,5));
				possibleMoves.add(new Square(4,1));
				possibleMoves.add(new Square(4,2));
				
				possibleMoves.add(new Square(5,4));
				possibleMoves.add(new Square(5,6));
				possibleMoves.add(new Square(5,0));
				possibleMoves.add(new Square(5,2));
				
				possibleMoves.add(new Square(6,5));
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,1));
			}
			
			if(getCurrentPlace().getRow()==4) {
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,6));
				possibleMoves.add(new Square(1,0));
				possibleMoves.add(new Square(1,1));
				
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,6));
				possibleMoves.add(new Square(2,0));
				possibleMoves.add(new Square(2,2));
				
				possibleMoves.add(new Square(3,4));
				possibleMoves.add(new Square(3,5));
				possibleMoves.add(new Square(3,1));
				possibleMoves.add(new Square(3,2));
				
				possibleMoves.add(new Square(5,4));
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,1));
				possibleMoves.add(new Square(5,2));
				
				possibleMoves.add(new Square(6,4));
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,2));
				
				possibleMoves.add(new Square(7,5));
				possibleMoves.add(new Square(7,6));
				possibleMoves.add(new Square(7,0));
				possibleMoves.add(new Square(7,1));
			}
			}
		
		if(getCurrentPlace().getRow()==7) {

			if(getCurrentPlace().getCol()==3) {
				possibleMoves.add(new Square(4,1));
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,4));
				possibleMoves.add(new Square(4,5));
				
				possibleMoves.add(new Square(5,0));
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,4));
				possibleMoves.add(new Square(5,6));
				
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,5));
				possibleMoves.add(new Square(6,6));
				
				possibleMoves.add(new Square(0,0));
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,5));
				possibleMoves.add(new Square(0,6));
				
				possibleMoves.add(new Square(1,0));
				possibleMoves.add(new Square(1,2));
				possibleMoves.add(new Square(1,4));
				possibleMoves.add(new Square(1,6));
				
				possibleMoves.add(new Square(2,1));
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,5));
			}
			
			if(getCurrentPlace().getCol()==4) {
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,3));
				possibleMoves.add(new Square(4,5));
				possibleMoves.add(new Square(4,6));
			
				possibleMoves.add(new Square(5,1));
				possibleMoves.add(new Square(5,3));
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,7));
				
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,2));
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,7));
				
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,2));
				possibleMoves.add(new Square(0,6));
				possibleMoves.add(new Square(0,7));
				
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,3));
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,7));
				
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,3));
				possibleMoves.add(new Square(2,5));
				possibleMoves.add(new Square(2,6));
			}
			}
		
		if(getCurrentPlace().getCol()==0) {
			if(getCurrentPlace().getRow()==3) {
				possibleMoves.add(new Square(0,6));
				possibleMoves.add(new Square(0,7));
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,2));
				
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,7));
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,3));
				
				possibleMoves.add(new Square(2,5));
				possibleMoves.add(new Square(2,6));
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,3));
				
				possibleMoves.add(new Square(4,5));
				possibleMoves.add(new Square(4,6));
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,3));
				
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,7));
				possibleMoves.add(new Square(5,1));
				possibleMoves.add(new Square(5,3));
				
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,7));
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,2));
			}
			
			if(getCurrentPlace().getRow()==4) {
				possibleMoves.add(new Square(1,6));
				possibleMoves.add(new Square(1,7));
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,2));
				
				possibleMoves.add(new Square(2,5));
				possibleMoves.add(new Square(2,7));
				possibleMoves.add(new Square(2,1));
				possibleMoves.add(new Square(2,3));
				
				possibleMoves.add(new Square(3,5));
				possibleMoves.add(new Square(3,6));
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,3));
				
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,6));
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,3));
				
				possibleMoves.add(new Square(6,5));
				possibleMoves.add(new Square(6,7));
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,3));
				
				possibleMoves.add(new Square(7,6));
				possibleMoves.add(new Square(7,7));
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,2));
			}
			}
		
		if(getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==1) {
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(6,2));
			possibleMoves.add(new Square(6,3));
			
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,4));
			
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,4));
			
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,4));
			
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,2));
			possibleMoves.add(new Square(3,4));
			
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,2));
			possibleMoves.add(new Square(4,3));
			}
		
		if(getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==6) {
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,5));
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,0));
			
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,1));
			
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,1));
			
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,4));
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,1));
			
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,1));
			
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,0));
			}
		
		if(getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==6) {
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,0));
			
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,1));
			
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,1));
			
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,1));
			
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,1));
			
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,5));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,0));
			}
		
		if(getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==1) {
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,2));
			possibleMoves.add(new Square(3,3));
			
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,2));
			possibleMoves.add(new Square(4,4));
			
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,4));
			
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,4));
			
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,4));
			
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,2));
			possibleMoves.add(new Square(1,3));
			}
		
		if(getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==2) {
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(6,1));
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,4));
			
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,1));
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,5));
			
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,5));
			
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,4));
			possibleMoves.add(new Square(2,5));
			
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,5));
			
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,4));
			}
		
		if(getCurrentPlace().getRow()==1 && getCurrentPlace().getCol()==5) {
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,7));
			
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,0));
			
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,0));
			
			possibleMoves.add(new Square(2,2));
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,0));
			
			possibleMoves.add(new Square(3,2));
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,0));
			
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,7));
			}
		
		if(getCurrentPlace().getRow()==2 && getCurrentPlace().getCol()==6) {
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,0));
			
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,1));
			
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,1));
			
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,1));
			
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,5));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,1));
			
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,5));
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,0));
			}
		
		if(getCurrentPlace().getRow()==5 && getCurrentPlace().getCol()==6) {
			possibleMoves.add(new Square(2,4));
			possibleMoves.add(new Square(2,5));
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,0));
			
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,5));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,1));
			
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,1));
			
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(6,1));
			
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,5));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,1));
			
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,5));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,0));
			}
		
		if(getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==5) {
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,7));
			
			possibleMoves.add(new Square(4,2));
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,0));
			
			possibleMoves.add(new Square(5,2));
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,0));
			
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,0));
			
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,0));
			
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,7));
			}
		
		if(getCurrentPlace().getRow()==6 && getCurrentPlace().getCol()==2) {
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,4));
			
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,5));
			
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,5));
			
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,5));
			
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,1));
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,5));
			
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,1));
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,4));
			}
		
		if(getCurrentPlace().getRow()==5 && getCurrentPlace().getCol()==1) {
			possibleMoves.add(new Square(2,7));
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,2));
			possibleMoves.add(new Square(2,3));
			
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,2));
			possibleMoves.add(new Square(3,4));
			
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,4));
			
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,4));
			
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,4));
			
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,3));
			}
		
		if(getCurrentPlace().getRow()==2 && getCurrentPlace().getCol()==1) {
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,3));
			
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,4));
			
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,4));
			
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,4));
			
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,2));
			possibleMoves.add(new Square(4,4));
			
			possibleMoves.add(new Square(5,7));
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,2));
			possibleMoves.add(new Square(5,3));
			}
		
		if(getCurrentPlace().getRow()==1) {
			
			if(getCurrentPlace().getCol()==3) {
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,2));
				possibleMoves.add(new Square(6,4));
				possibleMoves.add(new Square(6,5));
				
				possibleMoves.add(new Square(7,0));
				possibleMoves.add(new Square(7,2));
				possibleMoves.add(new Square(7,4));
				possibleMoves.add(new Square(7,6));
				
				possibleMoves.add(new Square(0,0));
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,5));
				possibleMoves.add(new Square(0,6));
				
				possibleMoves.add(new Square(2,0));
				possibleMoves.add(new Square(2,1));
				possibleMoves.add(new Square(2,5));
				possibleMoves.add(new Square(2,6));
				
				possibleMoves.add(new Square(3,0));
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,4));
				possibleMoves.add(new Square(3,6));
				
				possibleMoves.add(new Square(4,1));
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,4));
				possibleMoves.add(new Square(4,5));
			}
			
			if(getCurrentPlace().getCol()==4) {
				possibleMoves.add(new Square(6,2));
				possibleMoves.add(new Square(6,3));
				possibleMoves.add(new Square(6,5));
				possibleMoves.add(new Square(6,6));
			
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,3));
				possibleMoves.add(new Square(7,5));
				possibleMoves.add(new Square(7,7));
				
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,2));
				possibleMoves.add(new Square(0,6));
				possibleMoves.add(new Square(0,7));
				
				possibleMoves.add(new Square(2,1));
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,6));
				possibleMoves.add(new Square(2,7));
				
				possibleMoves.add(new Square(3,1));
				possibleMoves.add(new Square(3,3));
				possibleMoves.add(new Square(3,5));
				possibleMoves.add(new Square(3,7));
				
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,3));
				possibleMoves.add(new Square(4,5));
				possibleMoves.add(new Square(4,6));
			}
			}
		
		if(getCurrentPlace().getCol()==6) {
			
			if(getCurrentPlace().getRow()==3) {
				possibleMoves.add(new Square(0,4));
				possibleMoves.add(new Square(0,5));
				possibleMoves.add(new Square(0,7));
				possibleMoves.add(new Square(0,0));
				
				possibleMoves.add(new Square(1,3));
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,7));
				possibleMoves.add(new Square(1,1));
				
				possibleMoves.add(new Square(2,3));
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,0));
				possibleMoves.add(new Square(2,1));
				
				possibleMoves.add(new Square(4,3));
				possibleMoves.add(new Square(4,4));
				possibleMoves.add(new Square(4,0));
				possibleMoves.add(new Square(4,1));
				
				possibleMoves.add(new Square(5,3));
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,7));
				possibleMoves.add(new Square(5,1));
				
				possibleMoves.add(new Square(6,4));
				possibleMoves.add(new Square(6,5));
				possibleMoves.add(new Square(6,7));
				possibleMoves.add(new Square(6,0));
			}
			
			if(getCurrentPlace().getRow()==4) {
				possibleMoves.add(new Square(1,4));
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,7));
				possibleMoves.add(new Square(1,0));
				
				possibleMoves.add(new Square(2,3));
				possibleMoves.add(new Square(2,5));
				possibleMoves.add(new Square(2,7));
				possibleMoves.add(new Square(2,1));
				
				possibleMoves.add(new Square(3,3));
				possibleMoves.add(new Square(3,4));
				possibleMoves.add(new Square(3,0));
				possibleMoves.add(new Square(3,1));
				
				possibleMoves.add(new Square(5,3));
				possibleMoves.add(new Square(5,4));
				possibleMoves.add(new Square(5,0));
				possibleMoves.add(new Square(5,1));
				
				possibleMoves.add(new Square(6,3));
				possibleMoves.add(new Square(6,5));
				possibleMoves.add(new Square(6,7));
				possibleMoves.add(new Square(6,1));
				
				possibleMoves.add(new Square(7,4));
				possibleMoves.add(new Square(7,5));
				possibleMoves.add(new Square(7,7));
				possibleMoves.add(new Square(7,0));
			}
			}
		
		if(getCurrentPlace().getRow()==6 ) {

			if(getCurrentPlace().getCol()==3) {
				possibleMoves.add(new Square(3,1));
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,4));
				possibleMoves.add(new Square(3,5));
				
				possibleMoves.add(new Square(4,0));
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,4));
				possibleMoves.add(new Square(4,6));
				
				possibleMoves.add(new Square(5,0));
				possibleMoves.add(new Square(5,1));
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,6));
				
				possibleMoves.add(new Square(7,0));
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,5));
				possibleMoves.add(new Square(7,6));
				
				possibleMoves.add(new Square(0,0));
				possibleMoves.add(new Square(0,2));
				possibleMoves.add(new Square(0,4));
				possibleMoves.add(new Square(0,6));
				
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,2));
				possibleMoves.add(new Square(1,4));
				possibleMoves.add(new Square(1,5));
			}
			
			if(getCurrentPlace().getCol()==4) {
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,3));
				possibleMoves.add(new Square(3,5));
				possibleMoves.add(new Square(3,6));
			
				possibleMoves.add(new Square(4,1));
				possibleMoves.add(new Square(4,3));
				possibleMoves.add(new Square(4,5));
				possibleMoves.add(new Square(4,7));
				
				possibleMoves.add(new Square(5,1));
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,6));
				possibleMoves.add(new Square(5,7));
				
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,2));
				possibleMoves.add(new Square(7,6));
				possibleMoves.add(new Square(7,7));
				
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,3));
				possibleMoves.add(new Square(0,5));
				possibleMoves.add(new Square(0,7));
				
				possibleMoves.add(new Square(1,2));
				possibleMoves.add(new Square(1,3));
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,6));
			}
			}
		
		if(getCurrentPlace().getCol()==1) {
			if(getCurrentPlace().getRow()==3) {
				possibleMoves.add(new Square(0,7));
				possibleMoves.add(new Square(0,0));
				possibleMoves.add(new Square(0,2));
				possibleMoves.add(new Square(0,3));
				
				possibleMoves.add(new Square(1,6));
				possibleMoves.add(new Square(1,0));
				possibleMoves.add(new Square(1,2));
				possibleMoves.add(new Square(1,4));
				
				possibleMoves.add(new Square(2,6));
				possibleMoves.add(new Square(2,7));
				possibleMoves.add(new Square(2,3));
				possibleMoves.add(new Square(2,4));
				
				possibleMoves.add(new Square(4,6));
				possibleMoves.add(new Square(4,7));
				possibleMoves.add(new Square(4,3));
				possibleMoves.add(new Square(4,4));
				
				possibleMoves.add(new Square(5,6));
				possibleMoves.add(new Square(5,0));
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,4));
				
				possibleMoves.add(new Square(6,7));
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,2));
				possibleMoves.add(new Square(6,3));
			}
			
			if(getCurrentPlace().getRow()==4) {
				possibleMoves.add(new Square(1,7));
				possibleMoves.add(new Square(1,0));
				possibleMoves.add(new Square(1,2));
				possibleMoves.add(new Square(1,3));
				
				possibleMoves.add(new Square(2,6));
				possibleMoves.add(new Square(2,0));
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,4));
				
				possibleMoves.add(new Square(3,6));
				possibleMoves.add(new Square(3,7));
				possibleMoves.add(new Square(3,3));
				possibleMoves.add(new Square(3,4));
				
				possibleMoves.add(new Square(5,6));
				possibleMoves.add(new Square(5,7));
				possibleMoves.add(new Square(5,3));
				possibleMoves.add(new Square(5,4));
				
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,2));
				possibleMoves.add(new Square(6,4));
				
				possibleMoves.add(new Square(7,7));
				possibleMoves.add(new Square(7,0));
				possibleMoves.add(new Square(7,2));
				possibleMoves.add(new Square(7,3));
			}
			}
		
		if(getCurrentPlace().getCol()==2 && getCurrentPlace().getRow()==2) {
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(7,1));
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,4));
			
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0,1));
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,5));
			
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(1,4));
			possibleMoves.add(new Square(1,5));
			
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,0));
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,5));
			
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,1));
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,5));
			
			possibleMoves.add(new Square(5,0));
			possibleMoves.add(new Square(5,1));
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,4));
			}
		
		if(getCurrentPlace().getRow()==2 && getCurrentPlace().getCol()==5 ) {
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,7));
			
			possibleMoves.add(new Square(0,2));
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,0));
			
			possibleMoves.add(new Square(1,2));
			possibleMoves.add(new Square(1,3));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(1,0));
			
			possibleMoves.add(new Square(3,2));
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,0));
			
			possibleMoves.add(new Square(4,2));
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,6));
			possibleMoves.add(new Square(4,0));
			
			possibleMoves.add(new Square(5,3));
			possibleMoves.add(new Square(5,4));
			possibleMoves.add(new Square(5,6));
			possibleMoves.add(new Square(5,7));
			}
		
		if(getCurrentPlace().getRow()==5 && getCurrentPlace().getCol()==5 ) {
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,4));
			possibleMoves.add(new Square(2,6));
			possibleMoves.add(new Square(2,7));
			
			possibleMoves.add(new Square(3,2));
			possibleMoves.add(new Square(3,4));
			possibleMoves.add(new Square(3,6));
			possibleMoves.add(new Square(3,0));
			
			possibleMoves.add(new Square(4,2));
			possibleMoves.add(new Square(4,3));
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,0));
			
			possibleMoves.add(new Square(6,2));
			possibleMoves.add(new Square(6,3));
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,0));
			
			possibleMoves.add(new Square(7,2));
			possibleMoves.add(new Square(7,4));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(7,0));
			
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,4));
			possibleMoves.add(new Square(0,6));
			possibleMoves.add(new Square(0,7));
			}
		
		if(getCurrentPlace().getRow()==5 && getCurrentPlace().getCol()==2 ) {
			possibleMoves.add(new Square(2,0));
			possibleMoves.add(new Square(2,1));
			possibleMoves.add(new Square(2,3));
			possibleMoves.add(new Square(2,4));
			
			possibleMoves.add(new Square(3,7));
			possibleMoves.add(new Square(3,1));
			possibleMoves.add(new Square(3,3));
			possibleMoves.add(new Square(3,5));
			
			possibleMoves.add(new Square(4,7));
			possibleMoves.add(new Square(4,0));
			possibleMoves.add(new Square(4,4));
			possibleMoves.add(new Square(4,5));
			
			possibleMoves.add(new Square(6,7));
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(6,4));
			possibleMoves.add(new Square(6,5));
			
			possibleMoves.add(new Square(7,7));
			possibleMoves.add(new Square(7,1));
			possibleMoves.add(new Square(7,3));
			possibleMoves.add(new Square(7,5));
			
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(0,1));
			possibleMoves.add(new Square(0,3));
			possibleMoves.add(new Square(0,4));
			}
		
		if(getCurrentPlace().getRow()==2) {

			if(getCurrentPlace().getCol()==3) {
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,2));
				possibleMoves.add(new Square(7,4));
				possibleMoves.add(new Square(7,5));
				
				possibleMoves.add(new Square(0,0));
				possibleMoves.add(new Square(0,2));
				possibleMoves.add(new Square(0,4));
				possibleMoves.add(new Square(0,6));
				
				possibleMoves.add(new Square(1,0));
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,5));
				possibleMoves.add(new Square(1,6));
				
				possibleMoves.add(new Square(3,0));
				possibleMoves.add(new Square(3,1));
				possibleMoves.add(new Square(3,5));
				possibleMoves.add(new Square(3,6));
				
				possibleMoves.add(new Square(4,0));
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,4));
				possibleMoves.add(new Square(4,6));
				
				possibleMoves.add(new Square(5,1));
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,4));
				possibleMoves.add(new Square(5,5));
			}
			
			if(getCurrentPlace().getCol()==4) {
				possibleMoves.add(new Square(7,2));
				possibleMoves.add(new Square(7,3));
				possibleMoves.add(new Square(7,5));
				possibleMoves.add(new Square(7,6));
			
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,3));
				possibleMoves.add(new Square(0,5));
				possibleMoves.add(new Square(0,7));
				
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,2));
				possibleMoves.add(new Square(1,6));
				possibleMoves.add(new Square(1,7));
				
				possibleMoves.add(new Square(3,1));
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,6));
				possibleMoves.add(new Square(3,7));
				
				possibleMoves.add(new Square(4,1));
				possibleMoves.add(new Square(4,3));
				possibleMoves.add(new Square(4,5));
				possibleMoves.add(new Square(4,7));
				
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,3));
				possibleMoves.add(new Square(5,5));
				possibleMoves.add(new Square(5,6));
			}
			}
		
		if(getCurrentPlace().getCol()==5) {
			
			if(getCurrentPlace().getRow()==3) {
				possibleMoves.add(new Square(0,3));
				possibleMoves.add(new Square(0,4));
				possibleMoves.add(new Square(0,6));
				possibleMoves.add(new Square(0,7));
				
				possibleMoves.add(new Square(1,2));
				possibleMoves.add(new Square(1,4));
				possibleMoves.add(new Square(1,6));
				possibleMoves.add(new Square(1,0));
				
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,3));
				possibleMoves.add(new Square(2,7));
				possibleMoves.add(new Square(2,0));
				
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,3));
				possibleMoves.add(new Square(4,7));
				possibleMoves.add(new Square(4,0));
				
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,4));
				possibleMoves.add(new Square(5,6));
				possibleMoves.add(new Square(5,0));
				
				possibleMoves.add(new Square(6,3));
				possibleMoves.add(new Square(6,4));
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,7));
			}
			
			if(getCurrentPlace().getRow()==4) {
				possibleMoves.add(new Square(1,3));
				possibleMoves.add(new Square(1,4));
				possibleMoves.add(new Square(1,6));
				possibleMoves.add(new Square(1,7));
				
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,6));
				possibleMoves.add(new Square(2,0));
				
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,3));
				possibleMoves.add(new Square(3,7));
				possibleMoves.add(new Square(3,0));
				
				possibleMoves.add(new Square(5,2));
				possibleMoves.add(new Square(5,3));
				possibleMoves.add(new Square(5,7));
				possibleMoves.add(new Square(5,0));
				
				possibleMoves.add(new Square(6,2));
				possibleMoves.add(new Square(6,4));
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,0));
				
				possibleMoves.add(new Square(7,3));
				possibleMoves.add(new Square(7,4));
				possibleMoves.add(new Square(7,6));
				possibleMoves.add(new Square(7,7));
			}
			}
		
		if(getCurrentPlace().getRow()==5 ) {
			if(getCurrentPlace().getCol()==3) {
				possibleMoves.add(new Square(2,1));
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,5));
				
				possibleMoves.add(new Square(3,0));
				possibleMoves.add(new Square(3,2));
				possibleMoves.add(new Square(3,4));
				possibleMoves.add(new Square(3,6));
				
				possibleMoves.add(new Square(4,0));
				possibleMoves.add(new Square(4,1));
				possibleMoves.add(new Square(4,5));
				possibleMoves.add(new Square(4,6));
				
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,5));
				possibleMoves.add(new Square(6,6));
				
				possibleMoves.add(new Square(7,0));
				possibleMoves.add(new Square(7,2));
				possibleMoves.add(new Square(7,4));
				possibleMoves.add(new Square(7,6));
				
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,2));
				possibleMoves.add(new Square(0,4));
				possibleMoves.add(new Square(0,5));
			}
			
			if(getCurrentPlace().getCol()==4) {
				possibleMoves.add(new Square(2,2));
				possibleMoves.add(new Square(2,3));
				possibleMoves.add(new Square(2,5));
				possibleMoves.add(new Square(2,6));
			
				possibleMoves.add(new Square(3,1));
				possibleMoves.add(new Square(3,3));
				possibleMoves.add(new Square(3,5));
				possibleMoves.add(new Square(3,7));
				
				possibleMoves.add(new Square(4,1));
				possibleMoves.add(new Square(4,2));
				possibleMoves.add(new Square(4,6));
				possibleMoves.add(new Square(4,7));
				
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,2));
				possibleMoves.add(new Square(6,6));
				possibleMoves.add(new Square(6,7));
				
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,3));
				possibleMoves.add(new Square(7,5));
				possibleMoves.add(new Square(7,7));
				
				possibleMoves.add(new Square(0,2));
				possibleMoves.add(new Square(0,3));
				possibleMoves.add(new Square(0,5));
				possibleMoves.add(new Square(0,6));
			}
			}
		
		if(getCurrentPlace().getCol()==2 ) {
			
			if(getCurrentPlace().getRow()==3) {
				possibleMoves.add(new Square(0,0));
				possibleMoves.add(new Square(0,1));
				possibleMoves.add(new Square(0,3));
				possibleMoves.add(new Square(0,4));
				
				possibleMoves.add(new Square(1,7));
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,3));
				possibleMoves.add(new Square(1,5));
				
				possibleMoves.add(new Square(2,7));
				possibleMoves.add(new Square(2,0));
				possibleMoves.add(new Square(2,4));
				possibleMoves.add(new Square(2,5));
				
				possibleMoves.add(new Square(4,7));
				possibleMoves.add(new Square(4,0));
				possibleMoves.add(new Square(4,4));
				possibleMoves.add(new Square(4,5));
				
				possibleMoves.add(new Square(5,7));
				possibleMoves.add(new Square(5,1));
				possibleMoves.add(new Square(5,3));
				possibleMoves.add(new Square(5,5));
				
				possibleMoves.add(new Square(6,0));
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,3));
				possibleMoves.add(new Square(6,4));
			}
			
			if(getCurrentPlace().getRow()==4) {
				possibleMoves.add(new Square(1,0));
				possibleMoves.add(new Square(1,1));
				possibleMoves.add(new Square(1,3));
				possibleMoves.add(new Square(1,4));
				
				possibleMoves.add(new Square(2,7));
				possibleMoves.add(new Square(2,1));
				possibleMoves.add(new Square(2,3));
				possibleMoves.add(new Square(2,5));
				
				possibleMoves.add(new Square(3,7));
				possibleMoves.add(new Square(3,0));
				possibleMoves.add(new Square(3,4));
				possibleMoves.add(new Square(3,5));
				
				possibleMoves.add(new Square(5,7));
				possibleMoves.add(new Square(5,0));
				possibleMoves.add(new Square(5,4));
				possibleMoves.add(new Square(5,5));
				
				possibleMoves.add(new Square(6,7));
				possibleMoves.add(new Square(6,1));
				possibleMoves.add(new Square(6,3));
				possibleMoves.add(new Square(6,5));
				
				possibleMoves.add(new Square(7,0));
				possibleMoves.add(new Square(7,1));
				possibleMoves.add(new Square(7,3));
				possibleMoves.add(new Square(7,4));
			}
			}
		
		if((getCurrentPlace().getCol()==3 || getCurrentPlace().getCol()==4)  && (getCurrentPlace().getRow()==3 || getCurrentPlace().getRow()==4) ) {

			possibleMoves.add(new Square(getCurrentPlace().getRow()-3,getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-3,getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-3,getCurrentPlace().getCol()+2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-3,getCurrentPlace().getCol()-2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-3));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+3));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+3));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-3));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+3));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-3));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+3));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-3));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+3,getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+3,getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+3,getCurrentPlace().getCol()+2));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+3,getCurrentPlace().getCol()-2));
			
			
			
			}
		return possibleMoves;
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