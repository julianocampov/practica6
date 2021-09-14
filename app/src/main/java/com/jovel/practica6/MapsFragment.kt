package com.jovel.practica6

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->

        val latArg = doubleArrayOf(6.179430883696847,6.168567877147931, 6.185280102577899, 6.200738440801432,  6.214525225660443,6.222462907335787, 6.235413604182567,6.237293518023979,6.243977599582438, 6.2569277647449635,6.26173177670217,6.267997812830007,6.210963806292671,6.198896624336378,6.183570905406215, 6.199620663043665)
        val longArg = doubleArrayOf( -75.60865162367823, -75.57545223799339, -75.58196604151382, -75.58469763653854,-75.57356113218756,-75.59835561010411, -75.59667462855043,-75.57040929032185, -75.57293076265235, -75.58847984202373,-75.59205192782527,-75.58658873777586,-75.57404857482192,-75.58460888812672,-75.5820598469842, -75.56506623936727)
            for (position in latArg.indices){
                val rest = LatLng(latArg.get(position),longArg.get(position))
                googleMap.addMarker(MarkerOptions().position(rest).title("Domino's Pizza"))
            }
        val cam = LatLng(6.217449648935273, -75.57860407577478)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cam,12.75F))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}