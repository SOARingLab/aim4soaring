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
package aim4.vehicle;

import aim4.driver.ProxyDriver;
import aim4.msg.udp.Real2ProxyMsg;

import java.net.SocketAddress;

/**
 * The interface of a proxy vehicle from the viewpoint of a simulator.
 */
public interface ProxyVehicleSimView extends AutoVehicleSimView {

    /**
     * {@inheritDoc}
     */
    @Override
    ProxyDriver getDriver();

    /**
     * Set this proxy vehicle's driver.
     *
     * @param driver the new driver to control this Vehicle
     */
    void setDriver(ProxyDriver driver);

    /**
     * @return the socket address
     */
    SocketAddress getSa();

    /**
     * @param sa the new socket address to set
     */
    void setSa(SocketAddress sa);

    /**
     * Process the incoming Real2Proxy message
     *
     * @param msg the Real2Proxy message
     */
    void processReal2ProxyMsg(Real2ProxyMsg msg);

}
