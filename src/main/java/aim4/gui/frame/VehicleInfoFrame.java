/*
Copyright (c) 2011 Tsz-Chiu Au, Peter Stone
University of Texas at Austin
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

3. Neither the name of the University of Texas at Austin nor the names of its
contributors may be used to endorse or promote products derived from this
software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package aim4.gui.frame;

import aim4.config.Constants;
import aim4.gui.Viewer;
import aim4.vehicle.VehicleSimView;

import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 * The vehicle information frame.
 */
@SuppressWarnings("serial")
public final class VehicleInfoFrame extends javax.swing.JFrame {

    /**
     * The current viewer object
     */
    Viewer viewer;
    /**
     * The vehicle
     */
    VehicleSimView vehicle;

    /**
     * Creates new form VehicleInfoFrame
     */
    public VehicleInfoFrame(Viewer viewer) {
        this.viewer = viewer;
        initComponents();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Rectangle rect = viewer.getBounds();
        this.setLocation((int) rect.getMaxX() + 1, (int) rect.getMinY());
        setVehicle(null);
    }

    /**
     * Set the vehicle.
     *
     * @param vehicle the vehicle
     */
    public void setVehicle(VehicleSimView vehicle) {
        this.vehicle = vehicle;
        if (vehicle != null) {
            vinLabel.setText(Integer.toString(vehicle.getVIN()));
            velocityLabel.setText(Constants.TWO_DEC.format(vehicle.getVelocity()));
            headingLabel.setText(Constants.TWO_DEC.format(vehicle.getHeading()));
            accelerationLabel.setText(Constants.TWO_DEC.format(
                    vehicle.getAcceleration()));
        } else {
            vinLabel.setText("");
            velocityLabel.setText("");
            headingLabel.setText("");
            accelerationLabel.setText("");
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        vinLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        velocityLabel = new javax.swing.JLabel();
        headingLabel = new javax.swing.JLabel();
        accelerationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("VIN:");

        vinLabel.setText("0");

        jLabel2.setText("Velocity:");

        jLabel3.setText("Heading:");

        jLabel4.setText("Acceleration:");

        velocityLabel.setText("0");

        headingLabel.setText("0");

        accelerationLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(velocityLabel)
                                        .addComponent(headingLabel)
                                        .addComponent(accelerationLabel)
                                        .addComponent(vinLabel))
                                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(vinLabel)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(velocityLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(headingLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(accelerationLabel))
                                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accelerationLabel;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel velocityLabel;
    private javax.swing.JLabel vinLabel;
    // End of variables declaration//GEN-END:variables
}
