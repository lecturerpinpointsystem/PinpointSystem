/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.model;

import edu.pinpoint.intity.Jadwal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jemmy
 */
public class TableJadwalModel extends AbstractTableModel {
    
    private List<Jadwal> list = new ArrayList<Jadwal>();

    public void setList(List<Jadwal> list) {
        this.list = list;
    }
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;

    }

    public boolean add(Jadwal e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Jadwal get(int i) {
        return list.get(i);
    }

    public Jadwal set(int i, Jadwal e) {
        try {
            return list.set(i, e);
        } finally {
            fireTableRowsUpdated(i, i);
        }
        
       
    }

    public Jadwal remove(int i) {
        try {
            return list.remove(i);
        } finally {
            fireTableRowsDeleted(i, i);
        }
    }

    
    
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0 : return "NIP";
            case 1 : return "NAMA";
            case 2 : return "MATAKULIAH";
            case 3 : return "RUANGAN";
            case 4 : return "HARI";
            case 5 : return "MULAI";
            case 6 : return "USAI";
            default : return null;
        }
    }
    
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getNip();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getMatakuliah();
            case 3 : return list.get(rowIndex).getRuangan();
            case 4 : return list.get(rowIndex).getHari();
            case 5 : return list.get(rowIndex).getMulai();
            case 6 : return list.get(rowIndex).getUsai();
            default : return null;
                
            
        }

    }
    
}
