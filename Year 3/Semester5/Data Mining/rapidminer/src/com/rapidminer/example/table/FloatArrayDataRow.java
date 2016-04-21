/*
 *  RapidMiner
 *
 *  Copyright (C) 2001-2013 by Rapid-I and the contributors
 *
 *  Complete list of developers available at our web site:
 *
 *       http://rapid-i.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package com.rapidminer.example.table;


/**
 * Implementation of DataRow that is backed by a float array. Please note that for most applications
 * the precision of floats should be high enough. The highest precision is provided by 
 * {@link com.rapidminer.example.table.DoubleArrayDataRow}s but these need the double amount compared
 * to these float representations which are therefore a good trade-off between precision and memory usage.
 *  
 * @author Ingo Mierswa
 */
public class FloatArrayDataRow extends DataRow {

    private static final long serialVersionUID = -3691818538613297744L;
    
	/** Holds the data for all attributes. */
    private float[] data;

    /** Creates a new data row backed by an primitive array. */
    public FloatArrayDataRow(float[] data) {
        this.data = data;
    }

    /** Returns the desired data for the given index. */
    @Override
	protected double get(int index, double defaultValue) {
        return data[index];
    }

    /** Sets the given data for the given index. */
    @Override
	protected void set(int index, double value, double defaultValue) {
        data[index] = (float)value;
    }

    /**
     * Creates a new array of the given size if necessary and copies the data
     * into the new array.
     */
    @Override
	protected void ensureNumberOfColumns(int numberOfColumns) {
        if (data.length >= numberOfColumns)
            return;
        float[] newData = new float[numberOfColumns];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    /** Does nothing. */
    @Override
	public void trim() {}

    /** Returns a string representation of the data row. */
    @Override
	public String toString() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < data.length; i++)
            result.append((i == 0 ? "" : ",") + data[i]);
        return result.toString();
    }
    
	@Override
	public int getType() {
		return DataRowFactory.TYPE_FLOAT_ARRAY;
	}
}
